/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import java.util.List;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.bean.TDotaUserTd;
import org.cloud.app.forum.vo.UserInputVo;

public interface TDotaUserTdMapper {

	/**
	 * 根据手机号查询用户
	 * 
	 * @param tel 手机号
	 * @return 用户实体
	 */
	TDotaUserTd getUserByTel(String tel);

	/**
	 * 新增用户
	 * 
	 * @param record 用户实体
	 * @return
	 */
	int insertSelective(TDotaUserTd record);

	/**
	 * 登录验证
	 * 
	 * @param record 用户实体
	 * @return 用户实体
	 */
	TDotaUserTd login(TDotaUserTd record);

	/**
	 * 获取用户所赋予的菜单组
	 * 
	 * @param userId 用户ID
	 * @return 用户所赋予的菜单组
	 */
	List<TDotaMenuTd> getUserMenus(Integer userId);

	/**
	 * 获取当前用户基本信息
	 * 
	 * @param userId 用户ID
	 * @return
	 */
	TDotaUserTd selectByPrimaryKey(Integer userId);

	/**
	 * 获取用户列表分页数据
	 * 
	 * @param input 用户查询条件
	 * @return 用户列表分页数据
	 */
	List<TDotaUserTd> getUserListData(UserInputVo input);

	/**
	 * 获取用户列表记录总数
	 * 
	 * @param input 用户查询条件
	 * @return 用户列表记录总数
	 */
	Integer getUserListCnt(UserInputVo input);

	/**
	 * 修改用户
	 * 
	 * @param record 用户信息
	 * @return
	 */
	int updateByPrimaryKeySelective(TDotaUserTd record);

}