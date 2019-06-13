/**
 * 
 */
package com.memfactory.utils.redis;

import java.util.Set;

import com.memfactory.utils.SerializeUtil;

import redis.clients.jedis.Jedis;

/**
 * Redis客户端
 * 
 * @author zhairp createDate: 2018-09-17
 */
public class RedisClient implements IJedis {

	@Override
	public boolean setnx(String key, String value) {
		Jedis jedis = RedisUtil.getJedis();
		Long result = jedis.setnx(key, value);
		RedisUtil.returnResource(jedis);
		return 1L == result ? true : false;
	}

	@Override
	public void set(byte[] key, byte[] value, int liveTime) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		jedis.expire(key, liveTime);
		RedisUtil.returnResource(jedis);
	}

	@Override
	public void set(String key, String value, int liveTime) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		jedis.expire(key, liveTime);
		RedisUtil.returnResource(jedis);
	}

	@Override
	public void set(String key, String value) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		RedisUtil.returnResource(jedis);
	}

	@Override
	public void set(String key, Object value) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key.getBytes(), SerializeUtil.serialize(value));
		RedisUtil.returnResource(jedis);
	}

	@Override
	public Set<String> keys(String pattern) {
		Jedis jedis = RedisUtil.getJedis();
		Set<String> value = jedis.keys(pattern);
		RedisUtil.returnResource(jedis);
		return value;
	}

	@Override
	public boolean exists(String key) {
		Jedis jedis = RedisUtil.getJedis();
		boolean value = jedis.exists(key);
		RedisUtil.returnResource(jedis);
		return value;
	}

	@Override
	public String get(String key) {
		Jedis jedis = RedisUtil.getJedis();
		String value = jedis.get(key);
		RedisUtil.returnResource(jedis);
		return value;
	}

	@Override
	public Object get(byte[] key) {
		Jedis jedis = RedisUtil.getJedis();
		Object value = SerializeUtil.unserialize(jedis.get(key));
		RedisUtil.returnResource(jedis);
		return value;
	}

	@Override
	public boolean del(String key) {
		Jedis jedis = RedisUtil.getJedis();
		Long result = jedis.del(key);
		RedisUtil.returnResource(jedis);
		return 1L == result;
	}

	@Override
	public boolean del(byte[] key) {
		Jedis jedis = RedisUtil.getJedis();
		Long result = jedis.del(key);
		RedisUtil.returnResource(jedis);
		return 1L == result;
	}

	@Override
	public boolean flushDB() {
		Jedis jedis = RedisUtil.getJedis();
		String str = jedis.flushDB();
		RedisUtil.returnResource(jedis);
		return "OK".equals(str);
	}

	@Override
	public String ping() {
		Jedis jedis = RedisUtil.getJedis();
		String str = jedis.ping();
		RedisUtil.returnResource(jedis);
		return str;
	}

	@Override
	public Long dbSize() {
		Jedis jedis = RedisUtil.getJedis();
		long len = jedis.dbSize();
		RedisUtil.returnResource(jedis);
		return len;
	}

}