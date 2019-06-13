/**
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: 
 * Date: Mon Jul 23 19:08:24 CST 2018
 * Description:
 */
package org.cloud.app.forum.bean;

import org.cloud.app.forum.common.BaseDomain;

/**
 * TDotaBlockTd t_dota_block_td
 */
public class TDotaBlockTd extends BaseDomain {
	/**
	 * 版块id t_dota_block_td.block_id
	 */
	private Integer blockId;

	/**
	 * 版块名称 t_dota_block_td.block_name
	 */
	private String blockName;

	/**
	 * 版块排序 t_dota_block_td.order_num
	 */
	private Integer orderNum;

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "TDotaBlockTd [blockId=" + blockId + ", blockName=" + blockName + ", orderNum=" + orderNum + "]";
	}

}