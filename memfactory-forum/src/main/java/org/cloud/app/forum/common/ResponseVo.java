/**
 * 
 */
package org.cloud.app.forum.common;

/**
 * 统一响应结果
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
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

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

}
