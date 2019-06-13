/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

/**
 * TDotaReplyTd t_dota_reply_td
 */
public class TDotaReplyTd extends BaseDomain {
	/**
	 * 回帖id t_dota_reply_td.reply_id
	 */
	private Integer replyId;

	/**
	 * 回帖内容 t_dota_reply_td.reply_content
	 */
	private String replyContent;

	/**
	 * 回帖人id t_dota_reply_td.user_id
	 */
	private Integer userId;

	/**
	 * 帖子id t_dota_reply_td.post_id
	 */
	private Integer postId;

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

}