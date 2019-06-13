/**
 * 
 */
package com.memfactory.pub.exception;

/**
 * Solr异常基类
 * 
 * @author zhairp createDate: 2018-09-12
 */
public class SolrException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SolrException() {
		super();
	}

	public SolrException(String message) {
		super(message);
	}

	public SolrException(String message, Throwable cause) {
		super(message, cause);
	}

	public SolrException(Throwable cause) {
		super(cause);
	}

	protected SolrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
