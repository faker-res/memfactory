/**
 * 
 */
package com.memfactory.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码工具
 * 
 * @author zhairp createDate: 2018-09-26
 */
public final class CodeUtil {
	private CodeUtil() {
	}

	/**
	 * 对字符串编码
	 * 
	 * @author zhairp createDate: 2018-09-26
	 * @param s           字符串
	 * @param charsetName 字符编码 eg.utf-8
	 * @return 编码后的字符串
	 * @throws UnsupportedEncodingException 异常类
	 */
	public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
		return URLEncoder.encode(s, charsetName);
	}

	/**
	 * 对字符串解码
	 * 
	 * @author zhairp createDate: 2018-09-26
	 * @param s           字符串
	 * @param charsetName 字符编码 eg.utf-8
	 * @return 解码后的字符串
	 * @throws UnsupportedEncodingException 异常类
	 */
	public static String decode(String s, String charsetName) throws UnsupportedEncodingException {
		return URLDecoder.decode(s, charsetName);
	}

}
