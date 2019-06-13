/**
 * 
 */
package com.memfactory.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhairp createDate: 2018-11-13
 */
public final class Base64Util {
	private static final Logger log = LoggerFactory.getLogger(Base64Util.class);
	static final Base64.Decoder decoder = Base64.getDecoder();
	static final Base64.Encoder encoder = Base64.getEncoder();

	// 编码
	public static String encode(final String text) {
		try {
			return encoder.encodeToString(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException | NullPointerException e) {
			log.error("编码异常{},text:{}", e, text);
			return null;
		}
	}

	// 解码
	public static String decode(final String encodedText) {
		try {
			return new String(decoder.decode(encodedText), "UTF-8");
		} catch (UnsupportedEncodingException | NullPointerException e) {
			log.error("解码异常{},text:{}", e, encodedText);
			return null;
		}
	}

}
