/**
 * 
 */
package com.memfactory.article.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhairp createDate: 2018-11-30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void getAllParentTest() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://uc.abcfintech.com/uc/getAllParent";
		System.out.println("resp:" + restTemplate.getForObject(url, String.class));
	}

}
