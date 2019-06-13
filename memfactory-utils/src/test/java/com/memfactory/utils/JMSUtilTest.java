/**
 * 
 */
package com.memfactory.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.utils.activemq.JMSUtil;

/**
 * @author zhairp createDate: 2018-09-19
 */
public class JMSUtilTest {
	private static final Logger LOG = LoggerFactory.getLogger(JMSUtilTest.class);
	static String queue = "ord.queue";

	public static void main(String[] args) {
//		sendMsg();
		receiveMsg();
	}

	/**
	 * createDate: 2018-09-19
	 */
	private static void receiveMsg() {
		/*
		 * JMSUtil.receiveMsg(queue, new MsgCallable() {
		 * 
		 * @Override public void dealMsg(String msg) { LOG.info("接收消息:{}", msg); } });
		 */
		JMSUtil.receiveMsg(queue, (msg) -> {
			LOG.info(">>>>>>>接收消息:{}", msg);
		});
	}

	/**
	 * createDate: 2018-09-19
	 */
	private static void sendMsg() {
		for (int i = 0; i < 3; i++) {
			JMSUtil.sendMsg(queue, "test..." + i);
		}
	}

}
