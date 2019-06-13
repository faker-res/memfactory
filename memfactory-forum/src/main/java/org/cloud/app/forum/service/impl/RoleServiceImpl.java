package org.cloud.app.forum.service.impl;

import java.util.List;

import org.cloud.app.forum.bean.TDotaRoleMenuBindTd;
import org.cloud.app.forum.bean.TDotaRoleTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.persistence.TDotaRoleMenuBindTdMapper;
import org.cloud.app.forum.persistence.TDotaRoleTdMapper;
import org.cloud.app.forum.service.RoleService;
import org.cloud.app.forum.util.BaseDomainUtil;
import org.cloud.app.forum.vo.RoleInputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TDotaRoleTdMapper tDotaRoleTdMapper;

	@Autowired
	private TDotaRoleMenuBindTdMapper tDotaRoleMenuBindTdMapper;

	@Override
	public TDotaRoleTd getRole(Integer roleId) {
		return tDotaRoleTdMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public void addRole(TDotaRoleTd role) {
		BaseDomainUtil.setBaseDomain(role);
		tDotaRoleTdMapper.insertSelective(role);
	}

	@Override
	public void roleEmpower(Integer roleId, List<Integer> menuIds) {
		if (!CollectionUtils.isEmpty(menuIds)) {
			menuIds.forEach(menuId -> {
				TDotaRoleMenuBindTd tDotaRoleMenuBindTd = new TDotaRoleMenuBindTd();
				tDotaRoleMenuBindTd.setRoleId(roleId);
				tDotaRoleMenuBindTd.setMenuId(menuId);
				BaseDomainUtil.setBaseDomain(tDotaRoleMenuBindTd);
				tDotaRoleMenuBindTdMapper.insertSelective(tDotaRoleMenuBindTd);
			});
		}
	}

	@Override
	public List<TDotaRoleTd> getAllRoles() {
		return tDotaRoleTdMapper.getAllRoles();
	}

	@Override
	public PageResult<TDotaRoleTd> getRoleList(RoleInputVo input) {
		Integer total = tDotaRoleTdMapper.getRoleListCnt(input);
		List<TDotaRoleTd> data = tDotaRoleTdMapper.getRoleListData(input);
		return new PageResult<TDotaRoleTd>(total, data);
	}

}
