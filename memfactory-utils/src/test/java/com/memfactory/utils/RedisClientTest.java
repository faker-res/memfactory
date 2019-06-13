/**
 * 
 */
package com.memfactory.utils;

import java.util.Set;

import org.junit.Test;

import com.memfactory.utils.redis.RedisClient;

/**
 * @author zhairp createDate: 2018-09-17
 */
public class RedisClientTest {
	RedisClient client = new RedisClient();

	@Test
	public void setTest() {
		client.set("10001", "zhangsan");
	}

	@Test
	public void getTest() {
		System.out.println(client.get("10001"));
	}

	@Test
	public void flushDBTest() {
		System.out.println(client.flushDB());
	}

	@Test
	public void set02Test() {
		client.set("10001", "zhangsan1", 1000 * 60 * 60 * 24);
	}

	@Test
	public void get02Test() {
		if (client.exists("10004")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>" + client.get("10004"));
		}
	}

	@Test
	public void delTest() {
		System.out.println(client.del("10005"));
	}

	@Test
	public void setexTest() {
		System.out.println(client.setnx("10004", "zhangsan23222"));
	}

	@Test
	public void dbSizeTest() {
		System.out.println(client.dbSize());
	}

	@Test
	public void keysTest() {
		Set<String> set = client.keys("*");
		System.out.println(set);
		set.forEach(action -> {
			System.out.println(client.del(action));
		});
	}
}
