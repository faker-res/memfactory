/**
 * 
 */
package com.abc.template.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author zhairp createDate: 2018-11-01
 */
@Data
@Component
@PropertySource("classpath:${spring.profiles.active}/solr.properties")
@ConfigurationProperties
public class SolrProperties {

	@Value("${solr.url}")
	private String solrUrl;

}
