/**
 * 
 */
package com.memfactory.utils.exception;

/**
 * ActiveMQ异常
 * 
 * @author zhairp createDate: 2018-09-19
 */
public class ActiveMQException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ActiveMQException() {
		super();
	}

	public ActiveMQException(String message) {
		super(message);
	}

	public ActiveMQException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActiveMQException(Throwable cause) {
		super(cause);
	}

	protected ActiveMQException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
