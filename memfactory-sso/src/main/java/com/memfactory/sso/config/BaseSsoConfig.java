/**
 * 
 */
package com.memfactory.sso.config;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ineunet.knife.config.AppConfig;
import com.ineunet.knife.util.StringUtils;
import com.memfactory.auth.util.AuthUtil;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.sso.bean.SsoRes;
import com.memfactory.sso.constant.AuthConstant;
import com.memfactory.sso.util.SsoUtil;
import com.memfactory.utils.JsonUtil;
import com.memfactory.utils.RestUtil;

/**
 * 登录拦截器
 * 
 * @author zhairp createDate: 2018-09-03
 */
public abstract class BaseSsoConfig extends WebMvcConfigurerAdapter implements SsoService {
	private static final Logger LOG = LoggerFactory.getLogger(BaseSsoConfig.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptorAdapter() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				Map<String, String> auth = SsoUtil.getUserToken(request, response);
				String userId = auth.get(AuthConstant.USER_ID);
				String token = auth.get(AuthConstant.TOKEN);
				ResponseVo responseVo = new ResponseVo();
				// token验证
				if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(token)) {
					responseVo.setSuccess(false);
					responseVo.setMsg(AuthConstant.NO_LOGIN);
					responseVo.setStatus(AuthConstant.FAILURE);
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					RestUtil.write(response, responseVo);
					return false;
				} else {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put(AuthConstant.USER_ID, userId);
					params.put(AuthConstant.TOKEN, token);
					SsoRes ssoRes = SsoUtil.verifyToken(getVerifyTokenUrl(), params);
					if (ssoRes.getErrorCode() != AuthConstant.PASS) {
						responseVo.setSuccess(false);
						responseVo.setMsg(ssoRes.getMsg());
						responseVo.setStatus(AuthConstant.FAILURE);
						response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
						RestUtil.write(response, responseVo);
						return false;
					}
				}
				// 权限验证
				String appKey = AppConfig.getString(AuthConstant.APP_KEY);
				String appSecret = AppConfig.getString(AuthConstant.APP_SECRET);
				// getRequestURI->getServletPath:不依赖于部署的项目名称
				String module = AppConfig.getString(request.getServletPath());
				if (LOG.isInfoEnabled()) {
					LOG.info("appKey:{},appSecret:{},userId:{},module:{}", appKey, appSecret, userId, module);
				}
				if (!StringUtils.isEmpty(module)) {
					if (!AuthUtil.judgeAccess(userId, module, appKey, appSecret)) {
						responseVo.setSuccess(false);
						responseVo.setMsg(AuthConstant.NO_AUTH);
						responseVo.setStatus(AuthConstant.FAILURE);
						RestUtil.write(response, responseVo);
						return false;
					}
				}
				HttpSession session = request.getSession();
				if (null == session.getAttribute(AuthConstant.USER_ID)) {
					// 添加用户信息到session中
					if (LOG.isInfoEnabled()) {
						LOG.info("session中userId:{},token:{}", userId, token);
					}
					session.setAttribute(AuthConstant.USER_ID, userId);
					session.setAttribute(AuthConstant.TOKEN, token);
					try {
						// 写入权限信息到Cookie中
						List<Map<String, Object>> auths = AuthUtil.getAccess(userId, appKey, appSecret);
						Cookie cookie = new Cookie(AuthConstant.AUTH_FLAG, URLEncoder.encode(JsonUtil.toString(auths), "utf-8"));
						// 防止cookie失效,session未失效
						// cookie.setMaxAge(60 * 30);
						response.addCookie(cookie);
					} catch (Exception ex) {
						LOG.error("权限异常", ex);
					}
				}
				return super.preHandle(request, response, handler);
			}

			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
				super.postHandle(request, response, handler, modelAndView);
			}
		});
	}

}
