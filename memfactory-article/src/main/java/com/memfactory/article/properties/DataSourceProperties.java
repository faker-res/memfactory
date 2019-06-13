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
@PropertySource("classpath:${spring.profiles.active}/dataSource.properties")
@ConfigurationProperties
public class DataSourceProperties {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	@Value("${spring.datasource.timeoutSeconds}")
	private Integer timeoutSeconds;

}
