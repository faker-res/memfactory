/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

/**
 * TDotaRoleTd t_dota_role_td
 */
public class TDotaRoleTd extends BaseDomain {
	/**
	 * 角色id t_dota_role_td.role_id
	 */
	private Integer roleId;

	/**
	 * 角色名称 t_dota_role_td.role_name
	 */
	private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}