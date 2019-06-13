/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import java.util.List;

import org.cloud.app.forum.bean.TDotaReplyTd;
import org.cloud.app.forum.vo.ReplyInputVo;

public interface TDotaReplyTdMapper {

	/**
	 * 回复帖子
	 * 
	 * @param record 回复帖子信息
	 * @return
	 */
	int insertSelective(TDotaReplyTd record);

	TDotaReplyTd selectByPrimaryKey(Integer replyId);

	int updateByPrimaryKeySelective(TDotaReplyTd record);

	/**
	 * 查询回帖列表分页数据
	 * 
	 * @param input 回帖查询条件
	 * @return 回帖列表分页数据
	 */
	List<TDotaReplyTd> getReplyListData(ReplyInputVo input);

	/**
	 * 查询回帖列表记录总数
	 * 
	 * @param input 回帖查询条件
	 * @return 回帖列表只记录总数
	 */
	Integer getReplyListCnt(ReplyInputVo input);

}