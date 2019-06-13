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
public class PostInputVo extends PageCondition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 帖子标题
	 */
	private String postTitle;

	/**
	 * 版块id
	 */
	private Integer blockId;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

}
