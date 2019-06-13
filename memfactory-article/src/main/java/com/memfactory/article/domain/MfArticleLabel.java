/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Aug 22 18:03:52 CST 2018
 * Description:
 */
package com.memfactory.article.domain;

import com.memfactory.article.common.BaseDomain;

/**
 * MfArticleLabel mf_article_label
 */
public class MfArticleLabel extends BaseDomain {
	/**
	 * 名称 mf_article_label.name
	 */
	private String name;

	/**
	 * 文章id mf_article_label.essay_id
	 */
	private Long essayId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEssayId() {
		return essayId;
	}

	public void setEssayId(Long essayId) {
		this.essayId = essayId;
	}

}