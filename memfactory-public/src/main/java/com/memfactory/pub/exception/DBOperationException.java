/**
 * 
 */
package com.memfactory.pub.exception;

/**
 * 数据库操作异常
 * 
 * @author zhairp createDate: 2018-09-12
 */
public class DBOperationException extends DBException {
	private static final long serialVersionUID = 1L;

	public DBOperationException() {
		super();
	}

	public DBOperationException(String message) {
		super(message);
	}

	public DBOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBOperationException(Throwable cause) {
		super(cause);
	}

	protected DBOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
