/**
 * 
 */
package com.memfactory.article.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhairp createDate: 2018-11-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvPropertiesTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EnvProperties envProperties;

	@Test
	public void envTest() {
		log.info("env:{}", envProperties.getEnv());
	}

}
