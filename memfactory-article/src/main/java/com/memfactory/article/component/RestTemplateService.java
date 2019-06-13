/**
 * 
 */
package com.memfactory.article.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhairp createDate: 2018-11-30
 */
@Component
public class RestTemplateService {
	private Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * restTemplate实例用于远程服务调用,类似于HttpUtil工具类
	 * @author zhairp createDate: 2018-11-30
	 * @param builder
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		log.info("builder:{}", builder);
		return builder.build();
	}

}
