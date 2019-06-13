/**
 * 
 */
package com.memfactory.sso.bean;

/**
 * 单点登录统一结果
 * 
 * @author zhairp
 *createDate: 2018-09-03
 */
public class SsoRes {
	private int errorCode;
	private String msg;
	private Object data;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "HttpResult [errorCode=" + errorCode + ", msg=" + msg + ", data=" + data + "]";
	}

}
