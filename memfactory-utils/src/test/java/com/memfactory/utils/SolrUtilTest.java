/*******************************************************************************
 *                                                                              
 *  COPYRIGHT (C) 2018-2048 Memfactory Limited - ALL RIGHTS RESERVED.                  
 *                                                                                                                                  *                                                                              
 *******************************************************************************/
package com.memfactory.utils;

import org.apache.solr.common.SolrDocument;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.utils.solr.util.SolrUtil;

/**
 * @author zhairp
 * @date 2018-09-02
 */
public class SolrUtilTest {
	private static final Logger LOG = LoggerFactory.getLogger(SolrUtilTest.class);

	@Test
	public void getSolrClientTest() {
		String solrHost = "http://118.31.237.80:8983/solr/";
		String coreName = "edb";
		LOG.info(">>>>>>>>>>>>>>>>>>>>" + SolrUtil.getSolrClient(solrHost, coreName));
	}

	@Test
	public void getDocByIdTest() {
		String solrHost = "http://118.31.237.80:8983/solr/";
		String coreName = "edb";
		String id = "7041";
		SolrDocument doc = SolrUtil.getDocById(solrHost, coreName, id);
		LOG.info(">>>>>>>>>>>>>>>>>>>>" + doc);
	}
}
