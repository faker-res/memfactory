/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

/**
 * TDotaMenuTd t_dota_menu_td
 */
public class TDotaMenuTd extends BaseDomain {
	/**
	 * 菜单id t_dota_menu_td.menu_id
	 */
	private Integer menuId;

	/**
	 * 菜单名称 t_dota_menu_td.menu_name
	 */
	private String menuName;

	/**
	 * 菜单地址 t_dota_menu_td.menu_pic
	 */
	private String menuPic;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPic() {
		return menuPic;
	}

	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

}