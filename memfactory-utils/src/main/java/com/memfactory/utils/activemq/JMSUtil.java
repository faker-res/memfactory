/**
 * 
 */
package com.memfactory.utils.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ineunet.knife.config.AppConfig;
import com.memfactory.utils.exception.ActiveMQException;

/**
 * JSM工具类
 * 
 * @author zhairp createDate: 2018-09-19
 */
public final class JMSUtil {
	private static final Logger LOG = LoggerFactory.getLogger(JMSUtil.class);
	// 队列服务地址
	private static String brokerURL = AppConfig.getString("activeMQ.brokerURL");
	// 连接工厂,JMS 用它创建连接
	private static ConnectionFactory connectionFactory = null;

	private JMSUtil() {
	}

	static {
		init();
	}

	private static void init() {
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, brokerURL);
	}

	/**
	 * 发送消息 createDate: 2018-09-19
	 * 
	 * @param dest 队列名字
	 * @param msg  消息
	 */
	public static void sendMsg(String dest, String msg) {
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(dest);
			MessageProducer producer = session.createProducer(destination);
			// 设置不持久化，此处由实际根据项目决定
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage message = session.createTextMessage(msg);
			producer.send(message);
			session.commit();
			connection.close();
		} catch (JMSException e) {
			throw new ActiveMQException(e);
		}
	}

	/**
	 *
	 * 接收消息 createDate: 2018-09-19
	 * 
	 * @param dest 队列名字
	 * @param call 消息回调函数
	 */
	public static void receiveMsg(String dest, MsgCallable call) {
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(dest);
			MessageConsumer consumer = session.createConsumer(destination);
			while (true) {
				TextMessage message = (TextMessage) consumer.receive();
				if (null != message) {
					call.dealMsg(message.getText());
				}
			}
		} catch (JMSException e) {
			throw new ActiveMQException(e);
		}
	}
}
