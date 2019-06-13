/*******************************************************************************
 *                                                                              
 *  COPYRIGHT (C) 2018-2048 Memfactory Limited - ALL RIGHTS RESERVED.                  
 *                                                                                                                                  *                                                                              
 *******************************************************************************/
package com.memfactory.utils.solr.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.utils.JsonUtil;

/**
 * Solr工具类
 * 
 * @author zhairp
 * createDate: 2018-09-04
 */
public final class SolrUtil {
	private static final Logger LOG = LoggerFactory.getLogger(SolrUtil.class);

	private SolrUtil() {
	}

	private static Map<String, SolrClient> map = new HashMap<String, SolrClient>();

	/**
	 * 获取SolrClient实例
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @return SolrClient实例
	 */
	public static SolrClient getSolrClient(String solrHost, String coreName) {
		if (null != map.get(coreName)) {
			return map.get(coreName);
		}
		HttpSolrClient.Builder build = new HttpSolrClient.Builder(solrHost + coreName);
		SolrClient solrClient = build.build();
		map.put(coreName, solrClient);
		return solrClient;
	}

	/**
	 * 批量新增文档
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @param docs     文档列表
	 * @return 状态编码
	 */
	public static int insertSolrDatas(String solrHost, String coreName, List<SolrInputDocument> docs) {
		UpdateResponse response = null;
		try {
			SolrClient sc = getSolrClient(solrHost, coreName);
			response = sc.add(docs);
			sc.commit();
		} catch (SolrServerException | IOException e) {
			LOG.error("保存记录到 solr 出错, coreName is {}, docs is {}", coreName, JsonUtil.toString(docs), e);
		}
		if (null != response) {
			return response.getStatus();
		}
		return -1;
	}

	/**
	 * 清空索引库所有文档
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @return
	 */
	public static int clearDataByCoreName(String solrHost, String coreName) {
		try {
			// 根据q=*:*策略全清数据并提交
			SolrClient sc = getSolrClient(solrHost, coreName);
			sc.deleteByQuery("*:*");
			sc.commit();
		} catch (SolrServerException | IOException e) {
			LOG.error("clearData error for solr, coreName is {}", coreName, e);
		}
		return 0;
	}

	/**
	 * 根据文档ID查询文档
	 * 
	 * @param solrHost Solr地址
	 * @param coreName 索引库名称
	 * @param id       文档ID
	 * @return SolrDocument实例
	 */
	public static SolrDocument getDocById(String solrHost, String coreName, String id) {
		try {
			return getSolrClient(solrHost, coreName).getById(id);
		} catch (SolrServerException | IOException e) {
			LOG.error("getDocById error for solr, coreName is {}, id is {}", coreName, id, e);
		}
		return null;
	}

}
