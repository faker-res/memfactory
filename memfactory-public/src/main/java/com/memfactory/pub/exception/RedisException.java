/**
 * 
 */
package com.memfactory.pub.exception;

/**
 * Redis异常基类
 * 
 * @author zhairp createDate: 2018-09-12
 */
public class RedisException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RedisException() {
		super();
	}

	public RedisException(String message) {
		super(message);
	}

	public RedisException(String message, Throwable cause) {
		super(message, cause);
	}

	public RedisException(Throwable cause) {
		super(cause);
	}

	protected RedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
