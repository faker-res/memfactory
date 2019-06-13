/**
 * 
 */
package com.memfactory.utils;

import org.junit.Test;

import com.memfactory.utils.redis.RedisUtil;

import redis.clients.jedis.Jedis;

/**
 * @author zhairp createDate: 2018-09-17
 */
public class RedisUtilTest {

	@Test
	public void getJedisTest() {
		Jedis jedis = RedisUtil.getJedis();
		System.out.println(jedis.ping());
	}

}
