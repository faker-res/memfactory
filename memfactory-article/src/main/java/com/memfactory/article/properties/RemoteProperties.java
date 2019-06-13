/**
 * 
 */
package com.memfactory.article.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author zhairp createDate: 2018-11-13
 */
@Data
@Component
@PropertySource("classpath:${spring.profiles.active}/remote.properties")
@ConfigurationProperties
public class RemoteProperties {

	@Value("${essay.addArticle}")
	private String addArticle;

}
