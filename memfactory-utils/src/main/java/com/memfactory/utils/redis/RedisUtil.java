/**
 * 
 */
package com.memfactory.utils.redis;

import com.ineunet.knife.config.AppConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis连接池工具类
 * 
 * @author zhairp createDate: 2018-09-17
 */
public final class RedisUtil {
	private RedisUtil() {
	}

	private static String ADDR = AppConfig.getString("redis.host");
	private static int PORT = AppConfig.getInteger("redis.port");
	private static String PASSWORD = AppConfig.getString("redis.password");
	private static int MAX_ACTIVE = AppConfig.getInteger("redis.maxActive");
	private static int MAX_IDLE = AppConfig.getInteger("redis.maxIdle");
	private static int MAX_WAIT = AppConfig.getInteger("redis.maxWait");
	private static boolean TEST_ON_BORROW = AppConfig.getBoolean("redis.testOnBorrow");
	private static boolean TEST_ON_RETURN = AppConfig.getBoolean("redis.testOnReturn");

	private static JedisPool jedisPool = null;

	/**
	 * 初始化Redis连接池 createDate: 2018-09-17
	 */
	private static void init() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(MAX_ACTIVE);
		config.setMaxIdle(MAX_IDLE);
		config.setMaxWaitMillis(MAX_WAIT);
		config.setTestOnBorrow(TEST_ON_BORROW);
		config.setTestOnReturn(TEST_ON_RETURN);
		jedisPool = new JedisPool(config, ADDR, PORT);
	}

	/**
	 * 获取Jedis实例 createDate: 2018-09-17
	 * 
	 * @return jedis实例
	 */
	public static Jedis getJedis() {
		if (jedisPool == null) {
			init();
		}
		Jedis resource = jedisPool.getResource();
		resource.auth(PASSWORD);
		return resource;
	}

	/**
	 * 释放jedis资源 createDate: 2018-09-17
	 * 
	 * @param jedis jedis实例
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResourceObject(jedis);
		}
	}

}
