/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: UserService.java
 * Author:   17090260
 * Date:     2018年7月11日 上午11:52:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.cloud.app.forum.service;

import java.util.List;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.bean.TDotaUserTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.vo.UserInputVo;

/**
 * 用户服务
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public interface UserService {
	/**
	 * 注册用户
	 * 
	 * @param user 用户信息
	 * @return 注册结果
	 */
	ResponseVo register(TDotaUserTd user);

	/**
	 * 用户登录
	 * 
	 * @param user 用户信息
	 * @return 登录结果
	 */
	ResponseVo login(TDotaUserTd user);

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
	 * @return 用户基本信息
	 */
	TDotaUserTd getUser(Integer userId);

	/**
	 * 退出系统
	 */
	void logout();

	/**
	 * 给用户赋予角色
	 * 
	 * @param userId 角色ID
	 * @param roles  角色ID组
	 */
	void userEmpower(Integer userId, List<Integer> roles);

	/**
	 * 查询用户列表
	 * 
	 * @param input 用户查询条件
	 * @return 统一分页结果
	 */
	PageResult<TDotaUserTd> getUserList(UserInputVo input);

	/**
	 * 新增用户
	 * 
	 * @param user 用户信息
	 */
	void addUser(TDotaUserTd user);

	/**
	 * 修改用户
	 * 
	 * @param user 用户信息
	 */
	void updateUser(TDotaUserTd user);

}
