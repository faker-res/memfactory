/**
 * 
 */
package org.cloud.app.forum.constant;

/**
 * 操作结果枚举
 * 
 * @author zhairp
 * @date 2018年8月16日
 * @since 0.0.1
 */
public enum OperationEnum {

	SUCCESS("1001", "操作成功"),

	FAILURE("1002", "操作失败"),

	USER_EXSIT_OR_PWD_NOT_SAME("1100", "用戶存在或者兩次密码不一致"),

	USER_NOT_EXSIT_OR_PWD_NOT_RIGHT("1101", "用戶不存在或者密码不对");

	private String code;
	private String msg;

	private OperationEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
