package com.memfactory.article.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.memfactory.article.annotation.ParamCheck;
import com.memfactory.article.domain.MfArticleColumn;
import com.memfactory.article.service.ColumnService;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.ResponseVoUtil;

/**
 * 栏目管理
 * 
 * @author zhairp createDate: 2018-11-21
 */
@RestController
@RequestMapping("column")
public class ColumnController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private ColumnService columnService;

	/**
	 * 新增栏目 createDate: 2018-09-20
	 * 
	 * @param column 栏目实体信息
	 * @return
	 */
	@RequestMapping("addColumn")
	public ResponseVo addColumn(@RequestBody @Valid MfArticleColumn column) {
		columnService.addColumn(column);
		return ResponseVoUtil.getSuccessResponse(null);
	}

	/**
	 * 由父栏目查询子栏目(列表) createDate: 2018-09-20
	 * 
	 * @param parentId 父栏目ID
	 * @return 子栏目列表
	 */
	@RequestMapping("getColumnListByParentId")
	public ResponseVo getColumnListByParentId(@ParamCheck Long parentId) {
		return ResponseVoUtil.getSuccessResponse(columnService.getColumnListByParentId(parentId));
	}

	/**
	 * 批量新增栏目
	 * 
	 * @author zhairp createDate: 2018-11-21
	 * @param requestObj [{ "columnName": "JS" }, { "columnName": "CSS" }]
	 * @return
	 */
	@PostMapping("batchAddColumns")
	public ResponseVo batchAddColumns(@RequestBody String requestObj) {
		log.info("---requestObj:{}", requestObj);
		List<MfArticleColumn> columns = JSON.parseArray(requestObj, MfArticleColumn.class);
		log.info("---columns:{}", JSON.toJSONString(columns));
		columnService.batchAddColumns(columns);
		return ResponseVoUtil.getSuccessResponse(null);
	}
}
