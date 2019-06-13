package com.memfactory.utils;

import redis.clients.jedis.Jedis;

/**
 * @author zhairp createDate: 2018-09-15
 */
public class RedisTest {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("47.99.81.136");
		jedis.auth("123456");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
	}

}
