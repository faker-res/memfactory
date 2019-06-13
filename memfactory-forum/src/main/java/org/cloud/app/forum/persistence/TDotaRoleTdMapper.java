/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import java.util.List;

import org.cloud.app.forum.bean.TDotaRoleTd;
import org.cloud.app.forum.vo.RoleInputVo;

public interface TDotaRoleTdMapper {

	/**
	 * 新增角色
	 * 
	 * @param record 角色实体
	 * @return
	 */
	int insertSelective(TDotaRoleTd record);

	/**
	 * 获取角色信息
	 * 
	 * @param roleId 角色ID
	 * @return 角色信息
	 */
	TDotaRoleTd selectByPrimaryKey(Integer roleId);

	/**
	 * updateByPrimaryKeySelective
	 * 
	 * @param TDotaRoleTd record
	 * @return int
	 */
	int updateByPrimaryKeySelective(TDotaRoleTd record);

	/**
	 * 获取系统所有角色，用于给用户分配角色
	 * 
	 * @return 系统所有角色
	 */
	List<TDotaRoleTd> getAllRoles();

	/**
	 * 查询角色列表分页数据
	 * 
	 * @return 角色列表分页数据
	 */
	List<TDotaRoleTd> getRoleListData(RoleInputVo input);

	/**
	 * 查询角色列表记录总数
	 * 
	 * @return 角色列表记录总数
	 */
	Integer getRoleListCnt(RoleInputVo input);
}