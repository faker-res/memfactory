/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import java.util.List;

import org.cloud.app.forum.bean.TDotaPostTd;
import org.cloud.app.forum.vo.PostInputVo;

public interface TDotaPostTdMapper {

	/**
	 * 发布帖子
	 * 
	 * @param record 帖子信息
	 */
	int insertSelective(TDotaPostTd record);

	/**
	 * 获取帖子信息
	 * 
	 * @param postId 帖子ID
	 * @return 帖子信息
	 */
	TDotaPostTd selectByPrimaryKey(Integer postId);

	/**
	 * 修改帖子
	 * 
	 * @param record 帖子信息
	 */
	int updateByPrimaryKeySelective(TDotaPostTd record);

	/**
	 * 查询帖子列表分页数据
	 * 
	 * @param input 帖子查询条件
	 * @return 帖子列表分页数据
	 */
	List<TDotaPostTd> getPostListData(PostInputVo input);

	/**
	 * 查询帖子列表记录总数
	 * 
	 * @param input 帖子查询条件
	 * @return 帖子列表记录总数
	 */
	Integer getPostListCnt(PostInputVo input);

}