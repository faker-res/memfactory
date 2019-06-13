/**
 * 
 */
package com.memfactory.article.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.memfactory.article.common.ArticleConstant;
import com.memfactory.article.domain.MfArticleEssay;
import com.memfactory.article.mapper.MfArticleEssayMapper;
import com.memfactory.article.properties.RemoteProperties;
import com.memfactory.article.service.EssayService;
import com.memfactory.article.vo.EssayQueryVo;
import com.memfactory.pub.commom.PageResult;
import com.memfactory.pub.commom.SortMethod;
import com.memfactory.utils.Base64Util;
import com.memfactory.utils.HttpProxyUtil;

/**
 * @author zhairp
 * @date 2018年8月22日
 * @since 0.0.1
 */
@Service
public class EssayServiceImpl implements EssayService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private MfArticleEssayMapper mfArticleEssayMapper;

	@Autowired
	private RemoteProperties remoteProperties;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getIndexMfArticleEssays(List<SortMethod> sorts, int limit) {
		if (limit <= 0) {
			limit = ArticleConstant.DEFAULT_NUM;
		}
		List<Object> args = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer(" select id, title, pic_url, column_id, source, source_url from mf_article_essay ");
		String SQL = sb.toString();
		if (!CollectionUtils.isEmpty(sorts)) {
			sb.append(" order by ");
			sorts.forEach(e -> {
				sb.append(e.getSortField() + " " + e.getSortMode() + ",");
			});
			int length = sb.toString().length();
			SQL = sb.toString().substring(0, length - 1);
		}
		SQL += " limit ? ";
		log.info(">>>>>>>>>>>>>>>>>>SQL:{}", SQL);
		args.add(limit);
		return jdbcTemplate.queryForList(SQL, args.toArray());
	}

	@Override
	public PageResult<MfArticleEssay> getMfArticleEssayList(EssayQueryVo condition) {
		List<MfArticleEssay> data = mfArticleEssayMapper.getMfArticleEssayListData(condition);
		Integer total = mfArticleEssayMapper.getMfArticleEssayListCnt(condition);
		return new PageResult<MfArticleEssay>(total, data);
	}

	@Override
	@Cacheable(value = "essay", key = "#id")
	public MfArticleEssay getMfArticleEssay(Long id) {
		return mfArticleEssayMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addEssay(MfArticleEssay essay) {
		mfArticleEssayMapper.insertSelective(essay);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("requestObj", Base64Util.encode(JSON.toJSONString(essay)));
		HttpProxyUtil.doGet(remoteProperties.getAddArticle(), params);
	}

}
