/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import org.cloud.app.forum.bean.TDotaUserRoleBindTd;
import org.cloud.app.forum.bean.TDotaUserRoleBindTdKey;

public interface TDotaUserRoleBindTdMapper {

	/**
	 * 给用户分配角色
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(TDotaUserRoleBindTd record);

	TDotaUserRoleBindTd selectByPrimaryKey(TDotaUserRoleBindTdKey key);

	int updateByPrimaryKeySelective(TDotaUserRoleBindTd record);

}