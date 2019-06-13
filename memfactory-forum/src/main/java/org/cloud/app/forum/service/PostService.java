/**
 * 
 */
package org.cloud.app.forum.service;

import org.cloud.app.forum.bean.TDotaPostTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.vo.PostInputVo;

/**
 * 帖子服务
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public interface PostService {

	/**
	 * 查询帖子列表
	 * 
	 * @param input 帖子查询条件
	 * @return 统一分页结果
	 */
	PageResult<TDotaPostTd> getPostList(PostInputVo input);

	/**
	 * 发布帖子
	 * 
	 * @param post 帖子信息
	 */
	void addPost(TDotaPostTd post);

	/**
	 * 获取帖子信息
	 * 
	 * @param postId 帖子ID
	 * @return
	 */
	TDotaPostTd getPost(Integer postId);

	/**
	 * 修改帖子
	 * @param post 帖子信息
	 */
	void updatePost(TDotaPostTd post);

}
