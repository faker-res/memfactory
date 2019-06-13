/**
 * 
 */
package com.memfactory.article.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.memfactory.utils.RestUtil;

/**
 * 拦截器配置类
 * 
 * @author zhairp
 * @date 2018年8月23日
 * @since 0.0.1
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptorAdapter() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				log.info(">>>>>>>>>>>>>>>>>>>>>>>preHandle invoked!");
				RestUtil.setRespHeader(response);
				return super.preHandle(request, response, handler);
			}

			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
				log.info(">>>>>>>>>>>>>>>>>>>>>>>postHandle invoked!");
				super.postHandle(request, response, handler, modelAndView);
			}
		});
	}

}
