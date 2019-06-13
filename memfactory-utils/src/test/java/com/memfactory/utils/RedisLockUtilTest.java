/**
 * 
 */
package com.memfactory.utils;

import com.memfactory.utils.redis.RedisLockUtil;

/**
 * @author zhairp createDate: 2018-09-18
 */
public class RedisLockUtilTest {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					String key = "100001";
					String text = "hello world";
					RedisLockUtil.doWithDistributedLock(key, () -> {
						System.out.println(text);
					});
				}
			}).start();
		}
	}
}
