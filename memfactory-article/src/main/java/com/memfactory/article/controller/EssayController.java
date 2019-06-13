/**
 * 
 */
package com.memfactory.article.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memfactory.article.annotation.ParamCheck;
import com.memfactory.article.domain.MfArticleEssay;
import com.memfactory.article.service.EssayService;
import com.memfactory.article.vo.EssayQueryVo;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.ResponseVoUtil;

/**
 * 文章管理
 * 
 * @author zhairp
 * @date 2018年8月22日
 * @since 0.0.1
 */
@RestController
@RequestMapping("essay")
public class EssayController {
	private Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private EssayService essayService;

	/**
	 * 查询文章详情
	 * 
	 * @param id 文章ID
	 * @return 文章实体
	 */
	@RequestMapping("getMfArticleEssay")
	public ResponseVo getMfArticleEssay(@ParamCheck Long id) {
		LOG.info(">>>>>>>>>>>>>>>>>>>>id:{}", id);
		return ResponseVoUtil.getSuccessResponse(essayService.getMfArticleEssay(id));
	}

	/**
	 * 查询文章列表
	 * 
	 * @param condition 文章查询条件
	 * @return 统一分页结果
	 */
	@RequestMapping("getMfArticleEssayList")
	public ResponseVo getMfArticleEssayList(EssayQueryVo condition) {
		return ResponseVoUtil.getSuccessResponse(essayService.getMfArticleEssayList(condition));
	}

	/**
	 * 获取最新或者最热的文章
	 * 
	 * @param sorts 排序方式
	 * @param limit 条数限制
	 * @return 文章列表
	 */
	@RequestMapping("getIndexMfArticleEssays")
	public ResponseVo getIndexMfArticleEssays(@RequestBody EssayQueryVo input) {
		return ResponseVoUtil.getSuccessResponse(essayService.getIndexMfArticleEssays(input.getSorts(), Integer.valueOf(input.getLimit())));
	}

	/**
	 * 新增文章 createDate: 2018-09-20
	 * 
	 * @param essay 文章实体信息
	 * @return
	 */
	@RequestMapping("addEssay")
	public ResponseVo addEssay(@RequestBody @Valid MfArticleEssay essay) {
		essayService.addEssay(essay);
		return ResponseVoUtil.getSuccessResponse(null);
	}

}
