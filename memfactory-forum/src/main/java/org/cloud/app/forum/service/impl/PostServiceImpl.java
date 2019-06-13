/**
 * 
 */
package org.cloud.app.forum.service.impl;

import java.util.List;

import org.cloud.app.forum.bean.TDotaPostTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.persistence.TDotaPostTdMapper;
import org.cloud.app.forum.service.PostService;
import org.cloud.app.forum.util.BaseDomainUtil;
import org.cloud.app.forum.vo.PostInputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private TDotaPostTdMapper tDotaPostTdMapper;

	@Override
	public PageResult<TDotaPostTd> getPostList(PostInputVo input) {
		Integer total = tDotaPostTdMapper.getPostListCnt(input);
		List<TDotaPostTd> data = tDotaPostTdMapper.getPostListData(input);
		return new PageResult<TDotaPostTd>(total, data);
	}

	@Override
	public void addPost(TDotaPostTd post) {
		BaseDomainUtil.setBaseDomain(post);
		tDotaPostTdMapper.insertSelective(post);
	}

	@Override
	public TDotaPostTd getPost(Integer postId) {
		return tDotaPostTdMapper.selectByPrimaryKey(postId);
	}

	@Override
	public void updatePost(TDotaPostTd post) {
		BaseDomainUtil.updateBaseDomain(post);
		tDotaPostTdMapper.updateByPrimaryKeySelective(post);
	}

}
