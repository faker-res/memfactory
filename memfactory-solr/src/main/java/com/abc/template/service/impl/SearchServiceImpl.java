package com.abc.template.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.params.FacetParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abc.template.properties.SolrProperties;
import com.abc.template.service.SearchService;
import com.abc.template.vo.AggQueryVo;
import com.abc.template.vo.FilterQueryVo;
import com.memfactory.pub.commom.PageResult;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.ResponseVoUtil;

/**
 * @author zhairp createDate: 2018-11-10
 */
@Service
public class SearchServiceImpl implements SearchService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private SolrProperties solrProperties;

	@Override
	public ResponseVo filterQuery(FilterQueryVo input) {
		SolrClient solr = new HttpSolrClient.Builder(solrProperties.getSolrUrl() + input.getCore()).build();
		SolrQuery query = new SolrQuery();
		StringBuffer sb = new StringBuffer("*:* ");
		if (StringUtils.isNotEmpty(input.getQ())) {
			sb.append("AND ").append(input.getQ());
		}
		if (null == input.getStart() || input.getStart().intValue() < 0) {
			input.setStart(0);
		}
		if (null == input.getRows() || input.getRows().intValue() <= 0) {
			input.setRows(10);
		}
		if (StringUtils.isNotEmpty(input.getSort())) {
			query.set("sort", input.getSort());
		}
		query.setQuery(sb.toString());
		query.setStart(input.getStart());
		query.setRows(input.getRows());
		try {
			QueryResponse response = solr.query(query);
			log.info("返回结果:{}", response);
			Long total = response.getResults().getNumFound();
			return ResponseVoUtil.getSuccessResponse(new PageResult<SolrDocument>(total.intValue(), response.getResults()));
		} catch (SolrServerException | IOException e) {
			log.error("执行solr查询异常", e);
			return ResponseVoUtil.getFailureResponse(e.getMessage());
		}
	}

	@Override
	public ResponseVo aggQuery(AggQueryVo input) {
		SolrClient solr = new HttpSolrClient.Builder(solrProperties.getSolrUrl() + input.getCore()).build();
		SolrQuery query = new SolrQuery();
		StringBuffer sb = new StringBuffer("*:* ");
		if (StringUtils.isNotEmpty(input.getQ())) {
			sb.append("AND ").append(input.getQ());
		}
		query.setQuery(sb.toString());
		query.setRows(0);
		query.setFacet(true);
		query.setFacetMinCount(1);
		query.setFacetMissing(false);
		query.setFacetSort(FacetParams.FACET_SORT_COUNT);
		query.addFacetField(input.getFacetFields());
		try {
			QueryResponse response = solr.query(query);
			log.info("返回结果:{}", response);
			Map<String, List<String>> result = new HashMap<String, List<String>>();
			List<FacetField> facetFields = response.getFacetFields();
			for (FacetField facetField : facetFields) {
				String key = facetField.getName();
				List<Count> values = facetField.getValues();
				List<String> value = new ArrayList<String>();
				if (!CollectionUtils.isEmpty(values)) {
					for (Count count : values) {
						value.add(count.getName() + "," + count.getCount());
					}
				}
				result.put(key, value);
			}
			return ResponseVoUtil.getSuccessResponse(result);
		} catch (SolrServerException | IOException e) {
			log.error("执行solr查询异常", e);
			return ResponseVoUtil.getFailureResponse(e.getMessage());
		}
	}

}
