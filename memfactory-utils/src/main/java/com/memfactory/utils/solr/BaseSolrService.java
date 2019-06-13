/*******************************************************************************
 *                                                                              
 *  COPYRIGHT (C) 2018-2048 Memfactory Limited - ALL RIGHTS RESERVED.                  
 *                                                                                                                                  *                                                                              
 *******************************************************************************/
package com.memfactory.utils.solr;

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
 * @author zhairp
 * createDate: 2018-08-30
 */
public abstract class BaseSolrService implements SolrService {
	private static final Logger LOG = LoggerFactory.getLogger(BaseSolrService.class);

	private static Map<String, SolrClient> map = new HashMap<String, SolrClient>();

	@Override
	public SolrClient getSolrClient(String solrHost, String coreName) {
		if (null != map.get(coreName)) {
			return map.get(coreName);
		}
		HttpSolrClient.Builder build = new HttpSolrClient.Builder(solrHost + coreName);
		SolrClient solrClient = build.build();
		map.put(coreName, solrClient);
		return solrClient;
	}

	@Override
	public int insertSolrDatas(String solrHost, String coreName, List<SolrInputDocument> docs) {
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

	@Override
	public int clearDataByCoreName(String solrHost, String coreName) {
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

	@Override
	public SolrDocument getDocById(String solrHost, String coreName, String id) {
		try {
			return getSolrClient(solrHost, coreName).getById(id);
		} catch (SolrServerException | IOException e) {
			LOG.error("getDocById error for solr, coreName is {}, id is {}", coreName, id, e);
		}
		return null;
	}

}
