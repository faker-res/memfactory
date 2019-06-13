/**
 * 
 */
package com.memfactory.article.service;

import java.util.List;
import java.util.Map;

import com.memfactory.article.domain.MfArticleEssay;
import com.memfactory.article.vo.EssayQueryVo;
import com.memfactory.pub.commom.PageResult;
import com.memfactory.pub.commom.SortMethod;

/**
 * @author zhairp
 * @date 2018年8月22日
 * @since 0.0.1
 */
public interface EssayService {

	/**
	 * 获取最新或者最热的文章
	 * 
	 * @param sorts 排序方式
	 * @param limit 条数限制
	 * @return 文章列表
	 */
	List<Map<String, Object>> getIndexMfArticleEssays(List<SortMethod> sorts, int limit);

	/**
	 * 查询文章列表
	 * 
	 * @param condition 文章查询条件
	 * @return 统一分页结果
	 */
	PageResult<MfArticleEssay> getMfArticleEssayList(EssayQueryVo condition);

	/**
	 * 查询文章详情
	 * 
	 * @param id 文章ID
	 * @return 文章实体
	 */
	MfArticleEssay getMfArticleEssay(Long id);

	/**
	 * 新增文章 createDate: 2018-09-20
	 * 
	 * @param essay 文章实体信息
	 */
	void addEssay(MfArticleEssay essay);

}
