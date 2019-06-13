/**
 * 
 */
package com.memfactory.article.service;

import java.util.List;

import com.memfactory.article.domain.MfArticleColumn;

/**
 * @author zhairp createDate: 2018-11-21
 */
public interface ColumnService {

	/**
	 * 新增栏目 createDate: 2018-09-20
	 * 
	 * @param column 栏目实体信息
	 */
	void addColumn(MfArticleColumn column);

	/**
	 * 由父栏目查询子栏目(列表) createDate: 2018-09-20
	 * 
	 * @param parentId 父栏目ID
	 * @return 子栏目列表
	 */
	List<MfArticleColumn> getColumnListByParentId(Long parentId);

	/**
	 * 
	 *@author zhairp createDate: 2018-11-21
	 * @param columns
	 */
	void batchAddColumns(List<MfArticleColumn> columns);

}
