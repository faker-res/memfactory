/**
 * 
 */
package com.memfactory.pub.exception;

/**
 * 数据库配置异常
 * 
 * @author zhairp createDate: 2018-09-12
 */
public class DBConfigException extends DBException {
	private static final long serialVersionUID = 1L;

	public DBConfigException() {
		super();
	}

	public DBConfigException(String message) {
		super(message);
	}

	public DBConfigException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBConfigException(Throwable cause) {
		super(cause);
	}

	protected DBConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
