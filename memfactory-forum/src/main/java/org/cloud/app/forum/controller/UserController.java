package org.cloud.app.forum.controller;

import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.bean.TDotaUserTd;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.service.UserService;
import org.cloud.app.forum.util.HttpResponseUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.UserInputVo;
import org.cloud.app.forum.vo.UserRoleInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("register")
	public ResponseVo register(TDotaUserTd user, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return userService.register(user);
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("login")
	public ResponseVo login(TDotaUserTd user, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return userService.login(user);
	}

	/**
	 * 获取用户所赋予的菜单组
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUserMenus")
	public ResponseVo getUserMenus(Integer userId, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(userService.getUserMenus(userId));
	}

	/**
	 * 获取当前用户基本信息
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUser")
	public ResponseVo getUser(Integer userId, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(userService.getUser(userId));
	}

	/**
	 * 退出系统
	 * 
	 * @return
	 */
	@RequestMapping("logout")
	public ResponseVo logout(HttpServletResponse response) {
		HttpResponseUtil.response(response);
		userService.logout();
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 给用户赋予角色
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("userEmpower")
	public ResponseVo userEmpower(UserRoleInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		userService.userEmpower(input.getUserId(), input.getRoles());
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 查询用户列表
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("getUserList")
	public ResponseVo getUserList(UserInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(userService.getUserList(input));
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("addUser")
	public ResponseVo addUser(TDotaUserTd user, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		userService.addUser(user);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	public ResponseVo updateUser(TDotaUserTd user, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		userService.updateUser(user);
		return ResponseVoUtil.getDefaultResponse();
	}

}
