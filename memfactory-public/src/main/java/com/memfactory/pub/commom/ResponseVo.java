/**
 * 
 */
package com.memfactory.pub.commom;

/**
 * 统一响应结果
 * 
 * @author zhairp
 * @since 0.0.1 
 * createDate: 2018年8月30日
 */
public class ResponseVo {
	/**
	 * 成功标记
	 */
	private boolean success;
	/**
	 * 提示信息
	 */
	private String msg;
	/**
	 * 提示编码
	 */
	private String status;
	/**
	 * 结果数据
	 */
	private Object result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
