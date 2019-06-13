/**
 * 
 */
package com.memfactory.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhairp createDate: 2018-11-23
 */
public class HttpUtilTest {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void pushDataTest() {
		String url = "https://tour-pre.modeling.ai/invest-dc-inner-api/recommendedstock/pushData";
		JSONObject params = JSONObject.parseObject("{}");
		params.put("userId", "80114336991872214");
		params.put("broker", "海通证券");
		params.put("fileUrl", "http://pijmntsr1.bkt.clouddn.com/海通证券研究所重点推荐股票池（2018年7月）.xls");
		String resp = HttpUtil.doPost(url, (Object) params);
		log.info("resp:{}", resp);
	}

	@Test
	public void socketTest() {
		String url = "http://localhost:20000/article/request";
		String resp = HttpUtil.doGet(url);
		log.info("resp:{}", resp);
	}

}
