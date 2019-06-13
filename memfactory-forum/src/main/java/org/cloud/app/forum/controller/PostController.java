/**
 * 
 */
package org.cloud.app.forum.controller;

import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.bean.TDotaPostTd;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.service.PostService;
import org.cloud.app.forum.util.HttpResponseUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.PostInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帖子类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@RestController
@RequestMapping("/post")
public class PostController {
	private static final Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	/**
	 * 查询帖子列表
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("getPostList")
	public ResponseVo getPostList(PostInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(postService.getPostList(input));
	}

	/**
	 * 发布帖子
	 * 
	 * @param post
	 * @return
	 */
	@RequestMapping("addPost")
	public ResponseVo addPost(TDotaPostTd post, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		postService.addPost(post);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取帖子信息
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping("getPost")
	public ResponseVo getPost(Integer postId, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(postService.getPost(postId));
	}

	/**
	 * 修改帖子
	 * 
	 * @param post
	 * @return
	 */
	@RequestMapping("updatePost")
	public ResponseVo updatePost(TDotaPostTd post, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		postService.updatePost(post);
		return ResponseVoUtil.getDefaultResponse();
	}

}
