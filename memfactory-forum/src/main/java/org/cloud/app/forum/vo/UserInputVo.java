/**
 * 
 */
package org.cloud.app.forum.vo;

import org.cloud.app.forum.common.PageCondition;

/**
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public class UserInputVo extends PageCondition {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 手机号
	 */
	private String tel;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
