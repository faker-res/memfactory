/*******************************************************************************
 *                                                                              
 *  COPYRIGHT (C) 2018-2048 Memfactory Limited - ALL RIGHTS RESERVED.                  
 *                                                                                                                                  *                                                                              
 *******************************************************************************/
package com.memfactory.utils.solr;

import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

/**
 * Solr基础服务
 * 
 * @author zhairp
 * createDate: 2018-08-30
 */
public interface SolrService {

	/**
	 * 获取SolrClient实例
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @return SolrClient实例
	 */
	SolrClient getSolrClient(String solrHost, String coreName);

	/**
	 * 批量新增文档
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @param docs     文档列表
	 * @return 状态编码
	 */
	int insertSolrDatas(String solrHost, String coreName, List<SolrInputDocument> docs);

	/**
	 * 清空索引库所有文档
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @return
	 */
	int clearDataByCoreName(String solrHost, String coreName);

	/**
	 * 根据文档ID查询文档
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @param id       文档ID
	 * @return SolrDocument实例
	 */
	SolrDocument getDocById(String solrHost, String coreName, String id);

}
