/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

/**
 * TDotaPostTd t_dota_post_td
 */
public class TDotaPostTd extends BaseDomain {
	/**
	 * 帖子id t_dota_post_td.post_id
	 */
	private Integer postId;

	/**
	 * 帖子标题 t_dota_post_td.post_title
	 */
	private String postTitle;

	/**
	 * 帖子内容 t_dota_post_td.post_content
	 */
	private String postContent;

	/**
	 * 点击数 t_dota_post_td.click_num
	 */
	private Integer clickNum;

	/**
	 * 发帖人id t_dota_post_td.user_id
	 */
	private Integer userId;

	/**
	 * 版块id t_dota_post_td.block_id
	 */
	private Integer blockId;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

}