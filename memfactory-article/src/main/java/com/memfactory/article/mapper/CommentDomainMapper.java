/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Nov 21 16:15:44 CST 2018
 * Description:
 */
package com.memfactory.article.mapper;

import com.memfactory.article.domain.CommentDomain;

public interface CommentDomainMapper {

	int insertSelective(CommentDomain record);

	CommentDomain selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(CommentDomain record);

}