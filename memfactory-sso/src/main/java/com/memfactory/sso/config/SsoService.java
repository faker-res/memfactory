package com.memfactory.sso.config;

/**
 * @author zhairp
 *createDate: 2018-09-03
 */
public interface SsoService {

	/**
	 * 获取验证 token地址
	 * @return 验证 token地址
	 */
	String getVerifyTokenUrl();

}
