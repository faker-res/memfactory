/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Wed Aug 22 18:03:52 CST 2018
 * Description:
 */
package com.memfactory.article.mapper;

import java.util.List;

import com.memfactory.article.domain.MfArticleEssay;
import com.memfactory.article.vo.EssayQueryVo;
import com.memfactory.pub.commom.SortMethod;

public interface MfArticleEssayMapper {

	int insertSelective(MfArticleEssay record);

	MfArticleEssay selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MfArticleEssay record);

	List<MfArticleEssay> getMfArticleEssayListData(EssayQueryVo condition);

	Integer getMfArticleEssayListCnt(EssayQueryVo condition);

	List<MfArticleEssay> getIndexMfArticleEssays(List<SortMethod> sorts, int limit);

}