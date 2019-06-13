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
public class ReplyInputVo extends PageCondition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 帖子id 
	 */
	private Integer postId;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	

}
