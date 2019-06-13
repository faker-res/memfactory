/**
 * 
 */
package org.cloud.app.forum.service;

import org.cloud.app.forum.bean.TDotaReplyTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.vo.ReplyInputVo;

/**
 * 回帖服务
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public interface ReplyService {

	/**
	 * 查询回帖列表
	 * 
	 * @param input 回帖查询条件
	 * @return 统一分页结果
	 */
	PageResult<TDotaReplyTd> getReplyList(ReplyInputVo input);

	/**
	 * 回复帖子
	 * 
	 * @param reply 回帖信息
	 */
	void addReply(TDotaReplyTd reply);

}
