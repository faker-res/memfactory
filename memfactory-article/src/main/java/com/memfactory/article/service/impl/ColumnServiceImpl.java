/**
 * 
 */
package com.memfactory.article.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memfactory.article.domain.MfArticleColumn;
import com.memfactory.article.mapper.MfArticleColumnMapper;
import com.memfactory.article.service.ColumnService;

/**
 * @author zhairp createDate: 2018-11-21
 */
@Service
public class ColumnServiceImpl implements ColumnService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private MfArticleColumnMapper mfArticleColumnMapper;

	@Override
	public void addColumn(MfArticleColumn column) {
		mfArticleColumnMapper.insertSelective(column);
	}

	@Override
	public List<MfArticleColumn> getColumnListByParentId(Long parentId) {
		return mfArticleColumnMapper.getColumnListByParentId(parentId);
	}

	@Override
	public void batchAddColumns(List<MfArticleColumn> columns) {
		mfArticleColumnMapper.batchAddColumns(columns);
	}

}
