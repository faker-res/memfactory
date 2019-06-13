/**
 * 
 */
package com.memfactory.article.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author zhairp createDate: 2018-11-28
 */
@ConfigurationProperties(prefix = "dubbo")
@PropertySource("classpath:${spring.profiles.active}/dubbo.properties")
@Component
@Data
public class DubboProperties {
	private String applicationName;
	private String registryProtocol;
	private String registryAddress;

	@Override
	public String toString() {
		return "DubboProperties [applicationName=" + applicationName + ", registryProtocol=" + registryProtocol + ", registryAddress=" + registryAddress + "]";
	}

}
