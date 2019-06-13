/**
 * 
 */
package org.cloud.app.forum.controller;

import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.bean.TDotaReplyTd;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.service.ReplyService;
import org.cloud.app.forum.util.HttpResponseUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.ReplyInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回帖类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {
	private static final Logger log = LoggerFactory.getLogger(ReplyController.class);

	@Autowired
	private ReplyService replyService;

	/**
	 * 查询回帖列表
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("getUserList")
	public ResponseVo getUserList(ReplyInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(replyService.getReplyList(input));
	}

	/**
	 * 回复帖子
	 * 
	 * @param reply
	 * @return
	 */
	@RequestMapping("addReply")
	public ResponseVo addReply(TDotaReplyTd reply, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		replyService.addReply(reply);
		return ResponseVoUtil.getDefaultResponse();
	}

}
