/**
 * 
 */
package org.cloud.app.forum.common;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public abstract class BaseDomain {
	/**
	 * 创建时间 t_dota_block_td.create_time
	 */
	private String createTime;

	/**
	 * 更新时间 t_dota_block_td.update_time
	 */
	private String updateTime;

	/**
	 * 创建人 t_dota_block_td.create_user
	 */
	private String createUser;

	/**
	 * 更新人 t_dota_block_td.update_user
	 */
	private String updateUser;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
