/**
 * 
 */
package com.memfactory.article.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.memfactory.pub.commom.ResponseVo;

/**
 * @author zhairp createDate: 2018-11-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EssayControllerTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EssayController essayController;

	@Test
	public void getMfArticleEssayTest() {
		ResponseVo responseVo = essayController.getMfArticleEssay(1L);
		log.info("responseVo:{}", JSON.toJSONString(responseVo));
	}

}
