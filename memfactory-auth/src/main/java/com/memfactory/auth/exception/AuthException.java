/**
 * 
 */
package com.memfactory.auth.exception;

/**
 * 权限异常类
 * 
 * @author zhairp createDate: 2018-09-25
 */
public class AuthException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AuthException() {
		super();
	}

	public AuthException(String message) {
		super(message);
	}

	public AuthException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthException(Throwable cause) {
		super(cause);
	}

	protected AuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
