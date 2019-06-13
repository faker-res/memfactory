/**
 * 
 */
package com.memfactory.article.component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhairp createDate: 2018-11-15
 */
@Component
public class RedisService {

	@Autowired
	private RedisTemplate<String, String> stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 不存在此key则设置成功，返回true,否则返回false
	 *
	 * @param key   key
	 * @param value value
	 * @return 是否设置成功
	 */
	public boolean setIfAbsent(String key, String value) {
		return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
	}

	/**
	 * 判断某key是否存在
	 *
	 * @param key key
	 * @return bool
	 */
	public boolean existKey(String key) {
		return stringRedisTemplate.hasKey(key);
	}

	/**
	 * 根据key获取value
	 *
	 * @param key key
	 * @return value
	 */
	public String getValue(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 设置过期时间
	 *
	 * @param key     key
	 * @param timeout timeout
	 * @param unit    时间单位
	 */
	public void setExpireTime(String key, long timeout, TimeUnit unit) {
		stringRedisTemplate.expire(key, timeout, unit);
	}

	/**
	 * 设置值
	 *
	 * @param key     key
	 * @param value   value
	 * @param timeout 过期时间，单位秒
	 */
	public void setValue(String key, String value, int timeout, TimeUnit unit) {
		stringRedisTemplate.opsForValue().set(key, value);
		if (timeout > 0) {
			stringRedisTemplate.expire(key, timeout, unit);
		}

	}

	public void add2Set(String key, String value) {
		redisTemplate.opsForSet().add(key, value);
	}

	public Set<Object> getFromSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	public Set<String> getKeysByPattern(String pattern) {
		return redisTemplate.keys(pattern);
	}

	public void deleteBatch(Collection<String> collection) {
		redisTemplate.delete(collection);
	}
}
