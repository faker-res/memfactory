/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: UserServiceImpl.java
 * Author:   17090260
 * Date:     2018年7月11日 上午11:52:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.cloud.app.forum.service.impl;

import java.util.List;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.bean.TDotaUserRoleBindTd;
import org.cloud.app.forum.bean.TDotaUserTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.constant.OperationEnum;
import org.cloud.app.forum.persistence.TDotaUserRoleBindTdMapper;
import org.cloud.app.forum.persistence.TDotaUserTdMapper;
import org.cloud.app.forum.service.UserService;
import org.cloud.app.forum.util.BaseDomainUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.UserInputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TDotaUserRoleBindTdMapper tDotaUserRoleBindTdMapper;

	@Autowired
	private TDotaUserTdMapper dDotaUserTdMapper;

	@Override
	public ResponseVo register(TDotaUserTd user) {
		TDotaUserTd user1 = dDotaUserTdMapper.getUserByTel(user.getTel());
		if (null == user1 && user.getPassword().equals(user.getRepassword())) {
			BaseDomainUtil.setBaseDomain(user);
			dDotaUserTdMapper.insertSelective(user);
			return ResponseVoUtil.getDefaultResponse();
		}
		return ResponseVoUtil.getResponse(false, OperationEnum.USER_EXSIT_OR_PWD_NOT_SAME);
	}

	@Override
	public ResponseVo login(TDotaUserTd user) {
		TDotaUserTd user1 = dDotaUserTdMapper.login(user);
		if (null != user1) {
			// TODO 将用户添加到Session中
			return ResponseVoUtil.getDefaultResponse();
		}
		return ResponseVoUtil.getResponse(false, OperationEnum.USER_NOT_EXSIT_OR_PWD_NOT_RIGHT);
	}

	@Override
	public List<TDotaMenuTd> getUserMenus(Integer userId) {
		return dDotaUserTdMapper.getUserMenus(userId);
	}

	@Override
	public TDotaUserTd getUser(Integer userId) {
		return dDotaUserTdMapper.selectByPrimaryKey(userId);
	}

	@Override
	public void logout() {
		// TODO 将用户从Session中移除
	}

	@Override
	public void userEmpower(Integer userId, List<Integer> roles) {
		if (!CollectionUtils.isEmpty(roles)) {
			roles.forEach(roleId -> {
				TDotaUserRoleBindTd tDotaUserRoleBindTd = new TDotaUserRoleBindTd();
				tDotaUserRoleBindTd.setRoleId(roleId);
				tDotaUserRoleBindTd.setUserId(userId);
				BaseDomainUtil.setBaseDomain(tDotaUserRoleBindTd);
				tDotaUserRoleBindTdMapper.insertSelective(tDotaUserRoleBindTd);
			});
		}
	}

	@Override
	public PageResult<TDotaUserTd> getUserList(UserInputVo input) {
		List<TDotaUserTd> rows = dDotaUserTdMapper.getUserListData(input);
		Integer total = dDotaUserTdMapper.getUserListCnt(input);
		return new PageResult<TDotaUserTd>(total, rows);
	}

	@Override
	public void addUser(TDotaUserTd user) {
		BaseDomainUtil.setBaseDomain(user);
		dDotaUserTdMapper.insertSelective(user);
	}

	@Override
	public void updateUser(TDotaUserTd user) {
		BaseDomainUtil.updateBaseDomain(user);
		dDotaUserTdMapper.updateByPrimaryKeySelective(user);
	}

}
