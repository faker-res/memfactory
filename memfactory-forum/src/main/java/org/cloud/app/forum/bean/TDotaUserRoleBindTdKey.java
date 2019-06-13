/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

public class TDotaUserRoleBindTdKey extends BaseDomain {
	/**
	 * 用户id t_dota_user_role_bind_td.user_id
	 */
	private Integer userId;

	/**
	 * 角色id t_dota_user_role_bind_td.role_id
	 */
	private Integer roleId;

	/**
	 * @return t_dota_user_role_bind_td.user_id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param Integer userId (t_dota_user_role_bind_td.user_id )
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return t_dota_user_role_bind_td.role_id
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param Integer roleId (t_dota_user_role_bind_td.role_id )
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}