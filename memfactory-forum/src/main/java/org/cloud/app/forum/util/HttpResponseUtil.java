/**
 * 
 */
package org.cloud.app.forum.util;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhairp
 * @date 2018年8月19日
 * @since 0.0.1
 */
public final class HttpResponseUtil {
	private HttpResponseUtil() {
	}

	public static void response(HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Method", "POST,GET");
	}

}
