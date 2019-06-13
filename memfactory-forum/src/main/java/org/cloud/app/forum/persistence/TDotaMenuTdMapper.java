/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import java.util.List;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.vo.MenuInputVo;

public interface TDotaMenuTdMapper {

	/**
	 * 新增菜单
	 * 
	 * @param record 菜单实体
	 * @return
	 */
	int insertSelective(TDotaMenuTd record);

	/**
	 * 获取菜单信息
	 * 
	 * @param menuId 菜单ID
	 * @return 菜单信息
	 */
	TDotaMenuTd selectByPrimaryKey(Integer menuId);

	/**
	 * 修改菜单信息
	 * 
	 * @param record 菜单信息
	 * @return
	 */
	int updateByPrimaryKeySelective(TDotaMenuTd record);

	/**
	 * 获取系统所有菜单，用于给角色分配菜单
	 * 
	 * @return 系统所有菜单
	 */
	List<TDotaMenuTd> getAllMenus();

	/**
	 * 查询菜单列表分页数据
	 * 
	 * @param input 菜单查询条件
	 * @return 菜单列表分页数据
	 */
	List<TDotaMenuTd> getMenuListData(MenuInputVo input);

	/**
	 * 查询菜单列表记录总数
	 * 
	 * @param input 菜单查询条件
	 * @return 菜单列表记录总数
	 */
	Integer getMenuListCnt(MenuInputVo input);

}