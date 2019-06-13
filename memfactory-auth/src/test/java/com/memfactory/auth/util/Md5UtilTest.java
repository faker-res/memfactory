/**
 * 
 */
package com.memfactory.auth.util;

import java.io.File;

import org.junit.Test;

/**
 * @author zhairp createDate: 2018-09-25
 */
public class Md5UtilTest {

	@Test
	public void md5Test() {
		String pwd = "zhairongping";
		System.out.println(Md5Util.md5(pwd));
		System.out.println(Md5Util.md5(pwd).length());
	}

	@Test
	public void md5FileTest() {
		File file = new File("E:\\md5.txt");
		System.out.println(Md5Util.md5File(file));
		System.out.println(Md5Util.md5File(file).length());
	}
}
