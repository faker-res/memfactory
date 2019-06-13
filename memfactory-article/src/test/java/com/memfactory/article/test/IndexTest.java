/**
 * 
 */
package com.memfactory.article.test;

import java.util.HashMap;
import java.util.Map;

import com.memfactory.utils.HttpProxyUtil;

/**
 * @author zhairp createDate: 2018-11-13
 */
public class IndexTest {

	public static void main(String[] args) {
		String url = "http://localhost:24000/solrservice/index/addArt";
		String requestObj = "eyAJImlkIjogMSwgCSJ0aXRsZSI6ICJKREvmupDnoIHpmIXor7vvvJpCeXRlQnVmZmVyIiwgCSJwaWNVcmwiOiAiaHR0cDovL2luY2RuMS5iMC51cGFpeXVuLmNvbS8yMDE4LzAyLzM0Yjk4YTExN2JmZGM2MzFhMjUwZmQwMTdiYThhODljLmpwZyIsIAkiY29udGVudCI6ICJCdWZmZXLmmK9KYXZhIE5JT+S4reWvueS6jue8k+WGsuWMuueahOWwgeijheOAgiIsIAkiY29sdW1uSWQiOiAxMDAwLCAJInNvdXJjZSI6ICJpbXBvcnRuZXciLCAJInNvdXJjZVVybCI6ICJodHRwOi8vd3d3LmltcG9ydG5ldy5jb20vMjk1MzQuaHRtbCIgfQ==";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("requestObj", requestObj);
		System.out.println(HttpProxyUtil.doGet(url, params));
	}

}
