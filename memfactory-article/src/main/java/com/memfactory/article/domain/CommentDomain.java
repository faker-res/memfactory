/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Nov 21 16:15:44 CST 2018
 * Description:
 */
package com.memfactory.article.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.memfactory.article.common.BaseDomain;

/**
 * CommentDomain mf_article_comment
 */
public class CommentDomain extends BaseDomain {
	/**
	 * 文章id mf_article_comment.essay_id
	 */
	@NotNull(message = "文章id必传")
	private Long essayId;

	/**
	 * 评论内容 mf_article_comment.content
	 */
	@NotBlank(message = "评论内容必填")
	@Length(max = 200, message = "评论内容不超过200")
	private String content;

	public Long getEssayId() {
		return essayId;
	}

	public void setEssayId(Long essayId) {
		this.essayId = essayId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}