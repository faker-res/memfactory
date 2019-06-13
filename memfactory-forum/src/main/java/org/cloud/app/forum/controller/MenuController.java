/**
 * 
 */
package org.cloud.app.forum.controller;

import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.service.MenuService;
import org.cloud.app.forum.util.HttpResponseUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.MenuInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	private static final Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping("addMenu")
	public ResponseVo addMenu(TDotaMenuTd menu, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		menuService.addMenu(menu);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取菜单信息
	 * 
	 * @param menuId
	 * @return
	 */
	@RequestMapping("getMenu")
	public ResponseVo getMenu(Integer menuId, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		log.info(">>>>>>>>>>>>>>>>>getMenu:{}", menuId);
		return ResponseVoUtil.getResponse(menuService.getMenu(menuId));
	}

	/**
	 * 修改菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping("updateMenu")
	public ResponseVo updateMenu(TDotaMenuTd menu, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		menuService.updateMenu(menu);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取系统所有菜单，用于给角色分配菜单
	 * 
	 * @return
	 */
	@RequestMapping("getAllMenus")
	public ResponseVo getAllMenus(HttpServletResponse response) {
		HttpResponseUtil.response(response);
		log.info("***********getAllMenus");
		return ResponseVoUtil.getResponse(menuService.getAllMenus());
	}

	/**
	 * 查询菜单列表
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("getMenuList")
	public ResponseVo getMenuList(MenuInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(menuService.getMenuList(input));
	}

}
