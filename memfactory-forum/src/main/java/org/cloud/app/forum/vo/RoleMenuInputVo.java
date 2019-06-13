/**
 * 
 */
package org.cloud.app.forum.vo;

import java.util.List;

/**
 * @author zhairp
 * @date 2018年8月14日
 * @since 0.0.1
 */
public class RoleMenuInputVo {
	private Integer roleId;
	private List<Integer> menuIds;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<Integer> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}

}
