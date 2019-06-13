package com.memfactory.utils;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ineunet.knife.util.http.HttpClientUtils;

/**
 * 
 * @author zhairp
 * createDate: 2018-09-04
 */
public final class HttpProxyUtil {
	private static final Logger log = LoggerFactory.getLogger(HttpProxyUtil.class);

	private HttpProxyUtil() {
	}

	/**
	 * post方式
	 * 
	 * @param url    请求地址
	 * @param params 请求参数
	 * @return 响应结果
	 */
	public static String doPost(String url, Map<String, Object> params) {
		log.info("doPost url:[{}],params:[{}]", url, JsonUtil.toString(params));
		String result = HttpClientUtils.doPost(url, params);
		log.info("result:[{}]", result);
		return result;
	}

	/**
	 * get方式
	 * 
	 * @param url    请求地址
	 * @param params 请求参数
	 * @return 响应结果
	 */
	public static String doGet(String url, Map<String, Object> params) {
		log.info("doGet url:[{}],params:[{}]", url, JsonUtil.toString(params));
		String result = null;
		try {
			result = HttpClientUtils.doGet(url, params);
			log.info("result:[{}]", result);
		} catch (IOException e) {
			log.error("doGet fail", e);
		}
		return result;
	}

}
