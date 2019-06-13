/**
 * 
 */
package com.memfactory.article.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.ResponseVoUtil;

/**
 * 异常统一处理
 * 
 * @author zhairp createDate: 2018-11-27
 */
@RestControllerAdvice
public class CommonExceptionHandler {
	private Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = Exception.class)
	public ResponseVo exceptionHandler(Exception ex) {
		log.error("异常信息:", ex);
		return ResponseVoUtil.getFailureResponse(ex.getMessage());
	}

}
