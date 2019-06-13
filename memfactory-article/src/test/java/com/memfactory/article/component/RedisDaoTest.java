/**
 * 
 */
package com.memfactory.article.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhairp createDate: 2018-11-30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisDaoTest {

	@Autowired
	private RedisDao redisDao;

	@Test
	public void setValueTest() {
		redisDao.setKey("name", "zs");
	}

	@Test
	public void getValueTest() {
		System.out.println("name=" + redisDao.getValue("name"));
	}

}
