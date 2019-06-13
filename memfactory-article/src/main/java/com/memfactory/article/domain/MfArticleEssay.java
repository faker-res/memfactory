/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Aug 22 18:03:52 CST 2018
 * Description:
 */
package com.memfactory.article.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.memfactory.article.common.BaseDomain;

/**
 * MfArticleEssay mf_article_essay
 */
public class MfArticleEssay extends BaseDomain {

	/**
	 * 标题 mf_article_essay.title
	 */
	@NotBlank(message = "标题必填")
	private String title;

	/**
	 * 图片 mf_article_essay.pic_url
	 */
	private String picUrl;

	/**
	 * 栏目id mf_article_essay.column_id
	 */
	@NotNull(message = "栏目必填")
	private Long columnId;

	/**
	 * 文章来源 mf_article_essay.source
	 */
	private String source;

	/**
	 * 文章来源地址 mf_article_essay.source_url
	 */
	private String sourceUrl;

	/**
	 * 内容
	 */
	@NotBlank(message = "内容必填")
	@Length(max = 500, message = "内容长度限制500")
	private String content;

	// 评论数
	private Long commentCnt;

	public Long getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(Long commentCnt) {
		this.commentCnt = commentCnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

}