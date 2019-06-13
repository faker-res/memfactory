/**
 * 
 */
package com.memfactory.article.component;

import java.util.concurrent.TimeUnit;

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
public class RedisServiceTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RedisService redisService;

	@Test
	public void instanceTest() {
		log.info("---redisService:{}", redisService);
	}

	@Test
	public void setValueTest() {
		redisService.setValue("username1001", "1001-zrp", 1000 * 30, TimeUnit.MILLISECONDS);
	}

	@Test
	public void getValueTest() {
		String key = "username1001";
		String value = redisService.getValue(key);
		log.info("++++++++++++++++key:{},value:{}", key, value);
	}

}
