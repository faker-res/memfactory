/**
 * 
 */
package com.memfactory.sso.constant;

/**
 * 单点登录常量类
 * 
 * @author zhairp createDate: 2018-09-03
 */
public class AuthConstant {

	/**
	 * 用户ID
	 */
	public static final String USER_ID = "userId";
	/**
	 * token验证
	 */
	public static final String TOKEN = "token";

	/**
	 * token验证地址
	 */
	public static final String VERIFY_TOKEN_RUL = "sso.verifyToken.url";
	/**
	 * PASS
	 */
	public static final int PASS = 0;
	/**
	 * FAILURE
	 */
	public static final String FAILURE = "FAILURE";
	/**
	 * 未登录
	 */
	public static final String NO_LOGIN = "user not login.";

	/**
	 * 权限不足
	 */
	public static final String NO_AUTH = "权限不足,请先到权限管理系统配权限.";

	/**
	 * appKey
	 */
	public static final String APP_KEY = "auth.appKey";

	/**
	 * appSecret
	 */
	public static final String APP_SECRET = "auth.appSecret";

	/**
	 * 权限标志
	 */
	public static final String AUTH_FLAG = "authInfo";

}
