/**
 * 
 */
package com.memfactory.article.component;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author zhairp createDate: 2018-11-30
 */
@Repository
public class RedisDao {

	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * 写数据
	 * @author zhairp createDate: 2018-11-30
	 * @param key
	 * @param value
	 */
	public void setKey(String key, String value) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set(key, value, 1, TimeUnit.MINUTES);
	}

	/**
	 * 读数据
	 * @author zhairp createDate: 2018-11-30
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		return ops.get(key);
	}

}
