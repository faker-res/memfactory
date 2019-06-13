package com.memfactory.utils.activemq;

/**
 * 消息处理器
 * @author zhairp createDate: 2018-09-19
 */
@FunctionalInterface
public interface MsgCallable {

	void dealMsg(String msg);

}
