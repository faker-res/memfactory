package org.cloud.app.forum.controller;

import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.bean.TDotaRoleTd;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.service.RoleService;
import org.cloud.app.forum.util.HttpResponseUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.RoleInputVo;
import org.cloud.app.forum.vo.RoleMenuInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/addRole")
	public ResponseVo addRole(TDotaRoleTd role, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		roleService.addRole(role);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取角色信息
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("/getRole")
	public ResponseVo getRole(TDotaRoleTd input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(roleService.getRole(input.getRoleId()));
	}

	/**
	 * 给角色赋予菜单
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("/roleEmpower")
	public ResponseVo roleEmpower(RoleMenuInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		roleService.roleEmpower(input.getRoleId(), input.getMenuIds());
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取系统所有角色，用于给用户分配角色
	 * 
	 * @return
	 */
	@RequestMapping("/getAllRoles")
	public ResponseVo getAllRoles(HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(roleService.getAllRoles());
	}

	/**
	 * 查询角色列表
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("/getRoleList")
	public ResponseVo getRoleList(RoleInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(roleService.getRoleList(input));
	}

}
