package com.abc.template.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.template.service.SearchService;
import com.abc.template.vo.AggQueryVo;
import com.abc.template.vo.FilterQueryVo;
import com.alibaba.fastjson.JSON;
import com.memfactory.pub.commom.ResponseVo;

/**
 * solr搜索
 * 
 * @author zhairp createDate: 2018-11-09
 */
@RestController
@RequestMapping("search")
public class SearchController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private SearchService searchService;

	/**
	 * 过滤查询
	 * 
	 * @author zhairp createDate: 2018-11-10
	 * @param input
	 * @return
	 */
	@RequestMapping("filterQuery")
	public ResponseVo filterQuery(FilterQueryVo input) {
		log.info("查询条件:{}", JSON.toJSONString(input));
		if (!StringUtils.isNotEmpty(input.getCore())) {
			ResponseVo responseVo = new ResponseVo();
			responseVo.setSuccess(false);
			responseVo.setMsg("请输入core");
			return responseVo;
		}
		return searchService.filterQuery(input);
	}

	/**
	 * 聚合查询
	 * 
	 * @author zhairp createDate: 2018-11-10
	 * @param input
	 * @return
	 */
	@RequestMapping("aggQuery")
	public ResponseVo aggQuery(AggQueryVo input) {
		log.info("查询条件:{}", JSON.toJSONString(input));
		if (!StringUtils.isNotEmpty(input.getCore())) {
			ResponseVo responseVo = new ResponseVo();
			responseVo.setSuccess(false);
			responseVo.setMsg("请输入core");
			return responseVo;
		}
		return searchService.aggQuery(input);
	}

}
