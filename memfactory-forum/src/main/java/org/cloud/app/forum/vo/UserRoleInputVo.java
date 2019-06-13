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
public class UserRoleInputVo {
	private Integer userId;
	private List<Integer> roles;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getRoles() {
		return roles;
	}

	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

}
