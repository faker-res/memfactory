/**
 * 
 */
package com.memfactory.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memfactory.article.domain.CommentDomain;
import com.memfactory.article.mapper.CommentDomainMapper;
import com.memfactory.article.service.CommentService;

/**
 * @author zhairp createDate: 2018-11-21
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDomainMapper commentDomainMapper;

	@Override
	public void addComment(CommentDomain input) {
		commentDomainMapper.insertSelective(input);
	}

}
