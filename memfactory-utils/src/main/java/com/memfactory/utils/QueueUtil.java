/**
 * 
 */
package com.memfactory.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.utils.exception.QueueException;

/**
 * 队列工具类
 * 
 * @author zhairp createDate: 2018-09-20
 */
public final class QueueUtil {
	private static final Logger LOG = LoggerFactory.getLogger(QueueUtil.class);
	// 队列容器:键是队列类型，如日志队列，订单队列等，值是具体队列
	private static Map<String, LinkedBlockingQueue<String>> map = new ConcurrentHashMap<String, LinkedBlockingQueue<String>>();

	private QueueUtil() {
	}

	/**
	 * 从队列中取出元素
	 * 
	 * @author zhairp createDate: 2018-09-20
	 * @param queueType 队列类型
	 * @return 从队列中取元素
	 */
	public static String poll(String queueType) {
		try {
			if (!map.containsKey(queueType)) {
				return null;
			}
			return map.get(queueType).poll(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new QueueException("从队列中取元素异常", e);
		}
	}
	
	/**
	 * 
	 * 从队列中取出元素
	 * 
	 * @author zhairp createDate: 2018-09-20
	 * @param queueType 队列类型
	 * @param limit   队列取元素限制条数
	 * @return 元素
	 */
	public static List<String> poll(String queueType, int limit) {
		List<String> elements = new ArrayList<String>();
		if (!map.containsKey(queueType)) {
			return null;
		}
		LinkedBlockingQueue<String> queue = map.get(queueType);
		for (int i = 0; i < limit; i++) {
			String element = queue.poll();
			if (null != element) {
				elements.add(element);
			} else {
				break;
			}
		}
		return elements;
	}


	/**
	 * 向队列中添加元素
	 * 
	 * @author zhairp createDate: 2018-09-20
	 * @param queueType 队列类型
	 * @param element   元素
	 */
	public static void put(String queueType, String element) {
		try {
			if (!map.containsKey(queueType)) {
				map.put(queueType, new LinkedBlockingQueue<String>());
			}
			map.get(queueType).put(element);
		} catch (InterruptedException e) {
			throw new QueueException("向队列中添加元素异常", e);
		}
	}

	/**
	 * 清空所有类型队列数据
	 * 
	 * @author zhairp createDate: 2018-09-20
	 */
	public static void clear() {
		map.forEach((k, v) -> {
			v.clear();
		});
	}
}
