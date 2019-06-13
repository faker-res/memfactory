/**
 * 
 */
package com.memfactory.utils;

import org.junit.Test;

/**
 * @author zhairp createDate: 2018-11-13
 */
public class Base64UtilTest {

	@Test
	public void encodeTest() {
		System.out.println(Base64Util.encode("{ 	\"id\": 1, 	\"title\": \"JDK源码阅读：ByteBuffer\", 	\"picUrl\": \"http://incdn1.b0.upaiyun.com/2018/02/34b98a117bfdc631a250fd017ba8a89c.jpg\", 	\"content\": \"Buffer是Java NIO中对于缓冲区的封装。\", 	\"columnId\": 1000, 	\"source\": \"importnew\", 	\"sourceUrl\": \"http://www.importnew.com/29534.html\" }"));
	}

	@Test
	public void decodeTest() {
		System.out.println(Base64Util.decode("eyAJImlkIjogMSwgCSJ0aXRsZSI6ICJKREvmupDnoIHpmIXor7vvvJpCeXRlQnVmZmVyIiwgCSJwaWNVcmwiOiAiaHR0cDovL2luY2RuMS5iMC51cGFpeXVuLmNvbS8yMDE4LzAyLzM0Yjk4YTExN2JmZGM2MzFhMjUwZmQwMTdiYThhODljLmpwZyIsIAkiY29udGVudCI6ICJCdWZmZXLmmK9KYXZhIE5JT+S4reWvueS6jue8k+WGsuWMuueahOWwgeijheOAgiIsIAkiY29sdW1uSWQiOiAxMDAwLCAJInNvdXJjZSI6ICJpbXBvcnRuZXciLCAJInNvdXJjZVVybCI6ICJodHRwOi8vd3d3LmltcG9ydG5ldy5jb20vMjk1MzQuaHRtbCIgfQ=="));
	}

}
