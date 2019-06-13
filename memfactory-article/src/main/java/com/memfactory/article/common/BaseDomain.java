/**
 * 
 */
package com.memfactory.article.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhairp
 * @date 2018年8月22日
 * @since 0.0.1
 */
public class BaseDomain implements Serializable {
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 创建人ID mf_article_column.create_user_id
	 */
	private String createUserId;

	/**
	 * 创建人 mf_article_column.create_user_name
	 */
	private String createUserName;

	/**
	 * 更新人ID mf_article_column.update_user_id
	 */
	private String updateUserId;

	/**
	 * 更新人 mf_article_column.update_user_name
	 */
	private String updateUserName;

	/**
	 * 创建时间 mf_article_column.create_time
	 */
	private Date createTime;

	/**
	 * 更新时间 mf_article_column.update_time
	 */
	private Date updateTime;

	/**
	 * 状态:0-未删除 1-已删除 mf_article_column.flag
	 */
	private Integer flag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
