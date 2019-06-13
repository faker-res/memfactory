/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

public class TDotaRoleMenuBindTdKey extends BaseDomain {
	/**
	 * 角色id t_dota_role_menu_bind_td.role_id
	 */
	private Integer roleId;

	/**
	 * 菜单id t_dota_role_menu_bind_td.menu_id
	 */
	private Integer menuId;

	/**
	 * @return t_dota_role_menu_bind_td.role_id
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param Integer roleId (t_dota_role_menu_bind_td.role_id )
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return t_dota_role_menu_bind_td.menu_id
	 */
	public Integer getMenuId() {
		return menuId;
	}

	/**
	 * @param Integer menuId (t_dota_role_menu_bind_td.menu_id )
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}