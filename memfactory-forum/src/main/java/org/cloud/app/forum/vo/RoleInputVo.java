/**
 * 
 */
package org.cloud.app.forum.vo;

import org.cloud.app.forum.common.PageCondition;

/**
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public class RoleInputVo extends PageCondition {
	/**
	 * 角色名称
	 */
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
