/**
 * 
 */
package org.cloud.app.forum.vo;

import org.cloud.app.forum.common.PageCondition;

/**
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public class BlockInputVo extends PageCondition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 版块名称
	 */
	private String blockName;

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

}
