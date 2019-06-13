/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Aug 22 10:02:08 CST 2018
 * Description:
 */
package com.memfactory.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.memfactory.article.domain.MfArticleColumn;

public interface MfArticleColumnMapper {

	int insertSelective(MfArticleColumn record);

	MfArticleColumn selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MfArticleColumn record);

	List<MfArticleColumn> getColumnListByParentId(Long parentId);
	
	void batchAddColumns(@Param("columns") List<MfArticleColumn> columns);

}