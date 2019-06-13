package org.cloud.app.forum.service;

import java.util.List;

import org.cloud.app.forum.bean.TDotaRoleTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.vo.RoleInputVo;

/**
 * 角色服务
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public interface RoleService {

	/**
	 * 新增角色
	 * 
	 * @param role 角色信息
	 */
	void addRole(TDotaRoleTd role);

	/**
	 * 获取角色信息
	 * 
	 * @param roleId 角色ID
	 * @return 角色信息
	 */
	TDotaRoleTd getRole(Integer roleId);

	/**
	 * 给角色赋予菜单
	 * 
	 * @param roleId  角色ID
	 * @param menuIds 菜单ID组
	 */
	void roleEmpower(Integer roleId, List<Integer> menuIds);

	/**
	 * 获取系统所有角色，用于给用户分配角色
	 * 
	 * @return 系统所有角色
	 */
	List<TDotaRoleTd> getAllRoles();

	/**
	 * 查询角色列表
	 * 
	 * @param input 角色查询条件
	 * @return 统一分页结果
	 */
	PageResult<TDotaRoleTd> getRoleList(RoleInputVo input);

}
