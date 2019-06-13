/**
 * 
 */
package com.memfactory.utils;

import org.junit.Test;

/**
 * @author zhairp createDate: 2018-09-17
 */
public class SerializeUtilTest {

	@Test
	public void serializeTest() {
		byte[] bytes = SerializeUtil.serialize(new String("hello world"));
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
	}

	@Test
	public void unserializeTest() {
		Object obj = SerializeUtil.unserialize(SerializeUtil.serialize(new String("hello world")));
		System.out.println(obj);
	}

}
