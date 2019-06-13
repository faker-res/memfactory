/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Aug 22 18:03:52 CST 2018
 * Description:
 */
package com.memfactory.article.mapper;

import com.memfactory.article.domain.MfArticleLabel;

public interface MfArticleLabelMapper {

	int insertSelective(MfArticleLabel record);

	MfArticleLabel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MfArticleLabel record);

}