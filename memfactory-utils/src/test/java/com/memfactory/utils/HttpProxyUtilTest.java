package com.memfactory.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.pub.commom.ResponseVo;


/**
 * 
 * @author zhairp
 * @date 2018-09-02
 */
public class HttpProxyUtilTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void doGetTest() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("index", "province");
		param.put("pageIndex", 1);
		param.put("pageSize", 10);
		String result = HttpProxyUtil.doGet("http://118.31.237.80:8099/spiderweb-index/province/searchProvinceData", param);
		ResponseVo responseVo = JsonUtil.toBean(result, ResponseVo.class);
		Map<String, Object> data = JsonUtil.toBean(JsonUtil.toString(responseVo.getResult()), Map.class);
		log.info(">>>>>>>>>>>>>>>>data:{}", data);
	}

}
