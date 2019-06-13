/**
 * 
 */
package com.abc.template.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.template.domain.ArticleBean;
import com.abc.template.properties.SolrProperties;
import com.abc.template.service.ArticleIndexService;
import com.alibaba.fastjson.JSON;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.ResponseVoUtil;

/**
 * @author zhairp createDate: 2018-11-13
 */
@Service
public class ArticleIndexServiceImpl implements ArticleIndexService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private SolrProperties solrProperties;

	@Override
	public ResponseVo addArticle(String requestObj) {
		log.info("-------------requestObj------------" + requestObj);
		ArticleBean bean = JSON.parseObject(requestObj, ArticleBean.class);
		log.info("-------------bean------------" + bean);
		SolrClient solr = new HttpSolrClient.Builder(solrProperties.getSolrUrl() + "essay").build();
		try {
			solr.addBean(bean);
			solr.commit();
			return ResponseVoUtil.getSuccessResponse(null);
		} catch (IOException | SolrServerException e) {
			log.error("向索引库写数据异常", e);
			return ResponseVoUtil.getFailureResponse(e.getMessage());
		}
	}

	@Override
	public ResponseVo batchAddArticles(String requestObj) {
		log.info("-------------requestObj------------" + requestObj);
		List<ArticleBean> beans = JSON.parseArray(requestObj, ArticleBean.class);
		log.info("-------------beans------------" + beans);
		SolrClient solr = new HttpSolrClient.Builder(solrProperties.getSolrUrl() + "essay").build();
		try {
			solr.addBeans(beans);
			solr.commit();
			return ResponseVoUtil.getSuccessResponse(null);
		} catch (SolrServerException | IOException e) {
			return ResponseVoUtil.getFailureResponse(e.getMessage());
		}
	}

}
