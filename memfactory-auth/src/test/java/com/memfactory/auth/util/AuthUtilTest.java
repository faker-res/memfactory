/**
 * 
 */
package com.memfactory.auth.util;

import org.junit.Test;

import com.ineunet.knife.config.AppConfig;

/**
 * @author zhairp createDate: 2018-09-25
 */
public class AuthUtilTest {
	public static final String app_key = AppConfig.getString("auth.appKey");

	public static final String app_secret = AppConfig.getString("auth.appSecret");

	@Test
	public void constantTest() {
		System.out.println(app_key + ":" + app_secret);
	}

	@Test
	public void getAccessTest() {
		System.out.println(">>>>>>>>>>>>>>>>" + AuthUtil.getAccess("10180001", app_key, app_secret));
	}

	@Test
	public void judgeAccessTest() {
		System.out.println(">>>>>>>>>>>>>>>" + AuthUtil.judgeAccess("10180001", "x28979", app_key, app_secret));
	}

	@Test
	public void getAccessTest02() {
		System.out.println(">>>>>>>>>>>>>>>>" + AuthUtil.getAccess("80114397223624083", app_key, app_secret));
	}

	@Test
	public void judgeAccessTest02() {
		System.out.println(">>>>>>>>>>>>>>>" + AuthUtil.judgeAccess("80114397223624083", "1003", app_key, app_secret));
		System.out.println(">>>>>>>>>>>>>>>" + AuthUtil.judgeAccess("80114397223624083", "1004", app_key, app_secret));
	}

}
