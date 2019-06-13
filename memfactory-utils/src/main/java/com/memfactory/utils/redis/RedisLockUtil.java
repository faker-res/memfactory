/**
 * 
 */
package com.memfactory.utils.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.utils.exception.RedisException;

import redis.clients.jedis.Jedis;

/**
 * @author zhairp createDate: 2018-09-18
 */
public final class RedisLockUtil {
	private static final Logger LOG = LoggerFactory.getLogger(RedisLockUtil.class);
	private static final Long SUCCESS = 1L;
	private static Jedis jedis = RedisUtil.getJedis();

	private RedisLockUtil() {
	}

	/**
	 * 分布式处理任务 createDate: 2018-09-18
	 * 
	 * @param key  业务主键
	 * @param call 待处理的任务
	 */
	public static void doWithDistributedLock(String key, Callable call) {
		try {
			if (SUCCESS == jedis.setnx(key, " ")) {
				LOG.info(Thread.currentThread().getName() + " get distributed lock success");
				call.justDo();
				jedis.del(key);
			} else {
				LOG.info(Thread.currentThread().getName() + " get distributed lock fail");
				Thread.sleep(1000 * 3);
				doWithDistributedLock(key, call);
			}
		} catch (Exception ex) {
			throw new RedisException(ex);
		}
	}
}
