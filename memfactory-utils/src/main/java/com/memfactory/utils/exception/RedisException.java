/**
 * 
 */
package com.memfactory.utils.exception;

/**
 * Redis异常类
 * 
 * @author zhairp createDate: 2018-09-17
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
