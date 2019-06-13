/**
 * 
 */
package com.memfactory.utils;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * @author zhairp createDate: 2018-09-26
 */
public class CodeUtilTest {

	@Test
	public void encodeTest() throws UnsupportedEncodingException {
		System.out.println(CodeUtil.encode("hello123456张三", "utf-8"));
		System.out.println(CodeUtil.encode("{ 	/\"id/\": 1, 	/\"title/\": /\"JDK源码阅读：ByteBuffer/\", 	/\"picUrl/\": /\"http://incdn1.b0.upaiyun.com/2018/02/34b98a117bfdc631a250fd017ba8a89c.jpg/\", 	/\"content/\": /\"Buffer是Java NIO中对于缓冲区的封装。/\", 	/\"columnId/\": 1000, 	/\"source/\": /\"importnew/\", 	/\"sourceUrl/\": /\"http://www.importnew.com/29534.html/\" }", "utf-8"));
	}

	@Test
	public void decodeTest() throws UnsupportedEncodingException {
		System.out.println(CodeUtil.decode("hello123456%E5%BC%A0%E4%B8%89", "utf-8"));
	}

	@Test
	public void decodeTest02() throws UnsupportedEncodingException {
		System.out.println(CodeUtil.decode("%5B%7B%22accessId%22%3A%22702-104%22%2C%22accessName%22%3A%22%E9%A6%96%E9%A1%B5-%E6%97%A5%E5%8E%86%22%7D%5D", "utf-8"));
	}

}
