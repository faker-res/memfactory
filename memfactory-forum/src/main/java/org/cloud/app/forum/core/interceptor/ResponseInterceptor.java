/**
 * 
 */
package org.cloud.app.forum.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.util.HttpResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 获取用户请求，对响应对象统一跨域处理
 * 
 * @author zhairp
 * @date 2018年8月19日
 * @since 0.0.1
 */
public class ResponseInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(ResponseInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info(">>>>>>>>>>>>>>>>>>>>ResponseInterceptor preHandle...");
		HttpResponseUtil.response(response);
		return super.preHandle(request, response, handler);
	}

}
