/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import org.cloud.app.forum.bean.TDotaRoleMenuBindTd;
import org.cloud.app.forum.bean.TDotaRoleMenuBindTdKey;

public interface TDotaRoleMenuBindTdMapper {

	/**
	 * 给角色分配菜单
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(TDotaRoleMenuBindTd record);

	TDotaRoleMenuBindTd selectByPrimaryKey(TDotaRoleMenuBindTdKey key);

	int updateByPrimaryKeySelective(TDotaRoleMenuBindTd record);

}