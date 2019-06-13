/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

/**
 * TDotaUserTd t_dota_user_td
 */
public class TDotaUserTd extends BaseDomain {
	/**
	 * 用户id t_dota_user_td.user_id
	 */
	private Integer userId;

	/**
	 * 用户姓名 t_dota_user_td.user_name
	 */
	private String userName;

	/**
	 * 用户昵称 t_dota_user_td.nick_name
	 */
	private String nickName;

	/**
	 * 0是男，1是女 t_dota_user_td.sex
	 */
	private String sex;

	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机号
	 */
	private String tel;
	/**
	 * 电子邮件
	 */
	private String email;
	
	/**
	 * 确认密码
	 */
	private String repassword;
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}