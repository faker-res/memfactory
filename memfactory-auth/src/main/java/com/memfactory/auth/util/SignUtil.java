/**
 * 
 */
package com.memfactory.auth.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名工具类
 * 
 * @author zhairp createDate: 2018-09-25
 */
public final class SignUtil {
	private SignUtil() {
	};

	/**
	 * 请求参数签名
	 * 
	 * @author zhairp createDate: 2018-09-25
	 * @param params 请求参数
	 * @return 签名后的结果
	 */
	public static String getSign(Map<String, String> params) {
		Map<String, String> filtedMap = new TreeMap<>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			filtedMap.put(entry.getKey(), entry.getValue());
		}
		List<String> array = new LinkedList<>();
		for (Map.Entry<String, String> entry : filtedMap.entrySet()) {
			String pair = entry.getKey() + "=" + entry.getValue();
			array.add(pair.trim());
		}
		String signStr = String.join("&", array);
		String str = Md5Util.md5(signStr).toLowerCase();
		return str;
	}

}
