/**
 * 
 */
package com.memfactory.utils.exception;

/**
 * 队列异常
 * 
 * @author zhairp createDate: 2018-09-19
 */
public class QueueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QueueException() {
		super();
	}

	public QueueException(String message) {
		super(message);
	}

	public QueueException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueueException(Throwable cause) {
		super(cause);
	}

	protected QueueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
