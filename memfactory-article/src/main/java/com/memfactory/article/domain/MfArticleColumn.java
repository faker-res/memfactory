/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Aug 22 10:02:08 CST 2018
 * Description:
 */
package com.memfactory.article.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.memfactory.article.common.BaseDomain;

/**
 * MfArticleColumn mf_article_column
 */
public class MfArticleColumn extends BaseDomain {

	/**
	 * 栏目名称 mf_article_column.column_name
	 */
	@NotBlank(message = "栏目名称不能为空")
	private String columnName;

	/**
	 * 父栏目ID mf_article_column.parent_id
	 */
	@NotNull(message = "栏目ID不能为空")
	private Long parentId;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}