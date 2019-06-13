/**
 * 
 */
package org.cloud.app.forum.service.impl;

import java.util.List;

import org.cloud.app.forum.bean.TDotaReplyTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.persistence.TDotaReplyTdMapper;
import org.cloud.app.forum.service.ReplyService;
import org.cloud.app.forum.util.BaseDomainUtil;
import org.cloud.app.forum.vo.ReplyInputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private TDotaReplyTdMapper tDotaReplyTdMapper;

	@Override
	public PageResult<TDotaReplyTd> getReplyList(ReplyInputVo input) {
		Integer total = tDotaReplyTdMapper.getReplyListCnt(input);
		List<TDotaReplyTd> data = tDotaReplyTdMapper.getReplyListData(input);
		return new PageResult<TDotaReplyTd>(total, data);
	}

	@Override
	public void addReply(TDotaReplyTd reply) {
		BaseDomainUtil.setBaseDomain(reply);
		tDotaReplyTdMapper.insertSelective(reply);
	}

}
