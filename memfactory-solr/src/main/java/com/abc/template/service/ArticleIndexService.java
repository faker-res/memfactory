/**
 * 
 */
package com.abc.template.service;

import com.memfactory.pub.commom.ResponseVo;

/**
 * @author zhairp createDate: 2018-11-13
 */
public interface ArticleIndexService {

	ResponseVo addArticle(String requestObj);

	ResponseVo batchAddArticles(String requestObj);

}
