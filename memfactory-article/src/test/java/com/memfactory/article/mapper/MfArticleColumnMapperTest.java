/**
 * 
 */
package com.memfactory.article.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.memfactory.article.domain.MfArticleColumn;

/**
 * @author zhairp createDate: 2018-11-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MfArticleColumnMapperTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private MfArticleColumnMapper mfArticleColumnMapper;

	@Test
	public void getMfArticleEssayTest() {
		MfArticleColumn mfArticleColumn = mfArticleColumnMapper.selectByPrimaryKey(1000L);
		log.info("mfArticleColumn:{}", JSON.toJSONString(mfArticleColumn));
	}
}
