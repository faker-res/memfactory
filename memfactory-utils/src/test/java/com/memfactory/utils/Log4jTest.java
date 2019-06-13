package com.memfactory.utils;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author zhairp
 * @date 2018-09-02
 */
public class Log4jTest {

	@Test
	public void LogTest() {
		Logger log = Logger.getLogger(Log4jTest.class);
		log.info("测试");
	}

}