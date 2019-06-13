/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.persistence;

import java.util.List;

import org.cloud.app.forum.bean.TDotaBlockTd;
import org.cloud.app.forum.vo.BlockInputVo;

public interface TDotaBlockTdMapper {

	/**
	 * 新增版块
	 * 
	 * @param record 版块信息
	 */
	int insertSelective(TDotaBlockTd record);

	/**
	 * 获取版块信息
	 * 
	 * @param blockId 版块ID
	 * @return 版块信息
	 */
	TDotaBlockTd selectByPrimaryKey(Integer blockId);

	/**
	 * 修改版块
	 * 
	 * @param record 版块信息
	 */
	int updateByPrimaryKeySelective(TDotaBlockTd record);

	/**
	 * 查询版块列表分页数据
	 * 
	 * @param input 版块查询条件
	 * @return 版块列表分页数据
	 */
	List<TDotaBlockTd> getBlockListData(BlockInputVo input);

	/**
	 * 查询版块列表记录总数
	 * 
	 * @param input 版块查询条件
	 * @return 版块列表记录总数
	 */
	Integer getBlockListCnt(BlockInputVo input);

	/**
	 * 获取系统所有版块，用于过滤帖子
	 * 
	 * @return 系统所有版块
	 */
	List<TDotaBlockTd> getAllBlocks();

}