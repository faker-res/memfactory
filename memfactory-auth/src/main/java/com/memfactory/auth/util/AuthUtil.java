package com.memfactory.auth.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ineunet.knife.config.AppConfig;
import com.memfactory.auth.contant.AuthConstant;
import com.memfactory.auth.exception.AuthException;
import com.memfactory.utils.JsonUtil;

/**
 * 权限代理工具类
 * 
 * @author zhairp createDate: 2018-09-25
 */
public final class AuthUtil {
	private static final Logger LOG = LoggerFactory.getLogger(AuthUtil.class);

	private AuthUtil() {
	}

	/**
	 * 用户可以展示哪些权限
	 * 
	 * @author zhairp createDate: 2018-09-25
	 * @param userId    用户ID
	 * @param appKey    应用Key
	 * @param appSecret 应用Secret
	 * @return 权限列表
	 */
	public static List<Map<String, Object>> getAccess(String userId, String appKey, String appSecret) {
		try {
			Map<String, String> params = new HashMap<>();
			params.put(AuthConstant.CLIENT_KEY, appKey);
			params.put(AuthConstant.APP_SECRET, appSecret);
			params.put(AuthConstant.USERID, userId);
			String sign = SignUtil.getSign(params);
			params.put(AuthConstant.CLIENT_SECRET, sign);
			params.remove(AuthConstant.APP_SECRET);
			String url = AppConfig.getString("auth.accessIdListByUserId");
			LOG.info("doGet url:[{}],params:[{}]", url, JsonUtil.toString(params));
			String ret = HttpUtil.get(url, params, null);
			LOG.info("result:[{}]", ret);
			List<Map<String, Object>> showItems = new ArrayList<>();
			if (ret != null && !ret.isEmpty()) {
				JSONObject modelsRet = JSON.parseObject(ret);
				if (modelsRet != null && modelsRet.get("data") != null) {
					JSONArray array = (JSONArray) modelsRet.get("data");
					if (array.size() >= 0) {
						for (int i = 0; i < array.size(); i++) {
							showItems.add((Map) array.get(i));
						}
					}
				}
			}
			return showItems;
		} catch (Exception ex) {
			LOG.error("权限不足,请先到权限管理系统配权限", ex);
			throw new AuthException("权限不足,请先到权限管理系统配权限", ex);
		}
	}

	/**
	 * 用户是否可以访问该权限
	 * 
	 * @author zhairp createDate: 2018-09-25
	 * @param userId    用户ID
	 * @param module    权限ID
	 * @param appKey    应用Key
	 * @param appSecret 应用Secret
	 * @return 是否有权访问
	 */
	public static Boolean judgeAccess(String userId, String module, String appKey, String appSecret) {
		try {
			Map<String, String> params = new HashMap<>();
			params.put(AuthConstant.CLIENT_KEY, appKey);
			params.put(AuthConstant.APP_SECRET, appSecret);
			params.put(AuthConstant.USERID, userId);
			params.put(AuthConstant.ACCESSID, module);
			String sign = SignUtil.getSign(params);
			params.put(AuthConstant.CLIENT_SECRET, sign);
			params.remove(AuthConstant.APP_SECRET);
			String url = AppConfig.getString("auth.judgeAuthority");
			LOG.info("doGet url:[{}],params:[{}]", url, JsonUtil.toString(params));
			String ret = HttpUtil.get(url, params, null);
			LOG.info("result:[{}]", ret);
			Boolean result = false;
			if (ret != null && !ret.isEmpty()) {
				JSONObject modelsRet = JSON.parseObject(ret);
				if (modelsRet != null && modelsRet.get("data") != null) {
					result = (Boolean) modelsRet.get("data");
				}
			}
			return result;
		} catch (Exception ex) {
			LOG.error("权限不足,请先到权限管理系统配权限", ex);
			return false;
		}
	}

}
