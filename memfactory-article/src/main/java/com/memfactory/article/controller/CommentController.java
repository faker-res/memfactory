/**
 * 
 */
package com.memfactory.article.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memfactory.article.domain.CommentDomain;
import com.memfactory.article.service.CommentService;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.ResponseVoUtil;

/**
 * @author zhairp createDate: 2018-11-21
 */
@RestController
@RequestMapping("comment")
public class CommentController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private CommentService commentService;

	/**
	 * 添加评论
	 *@author zhairp createDate: 2018-11-21
	 * @param input
	 * @return
	 */
	@PostMapping("addComment")
	public ResponseVo addComment(@RequestBody @Valid CommentDomain input) {
		commentService.addComment(input);
		return ResponseVoUtil.getSuccessResponse(null);
	}

}
