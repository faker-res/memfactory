/**
 * 
 */
package com.memfactory.sso.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ineunet.knife.config.AppConfig;
import com.memfactory.sso.bean.SsoRes;
import com.memfactory.sso.constant.AuthConstant;
import com.memfactory.utils.HttpProxyUtil;
import com.memfactory.utils.JsonUtil;

/**
 * 单点系统服务
 * 
 * @author zhairp createDate: 2018-09-03
 */
public final class SsoUtil {
	private static final Logger log = LoggerFactory.getLogger(SsoUtil.class);

	private SsoUtil() {
	}

	/**
	 * 验证 token
	 * 
	 * @param params
	 * @return
	 */
	public static SsoRes verifyToken(Map<String, Object> params) {
		String result = HttpProxyUtil.doPost(AppConfig.getString(AuthConstant.VERIFY_TOKEN_RUL), params);
		SsoRes ssoRes = JsonUtil.toBean(result, SsoRes.class);
		return ssoRes;
	}

	/**
	 * 验证 token
	 * 
	 * @param verifyTokenUrl 验证 token地址
	 * @param params
	 * @return
	 */
	public static SsoRes verifyToken(String verifyTokenUrl, Map<String, Object> params) {
		String result = HttpProxyUtil.doPost(verifyTokenUrl, params);
		SsoRes ssoRes = JsonUtil.toBean(result, SsoRes.class);
		return ssoRes;
	}

	public static Map<String, String> getUserToken(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> auth = new HashMap<String, String>();
		auth.put(AuthConstant.USER_ID, request.getParameter(AuthConstant.USER_ID));
		auth.put(AuthConstant.TOKEN, request.getParameter(AuthConstant.TOKEN));
		return auth;
	}

}
