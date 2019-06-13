/**
 * 
 */
package com.memfactory.utils.exception;

/**
 * 数据库异常
 * 
 * @author zhairp createDate: 2018-09-15
 */
public class DBException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(Throwable cause) {
		super(cause);
	}

	protected DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
