/**
 * 
 */
package org.cloud.app.forum.service;

import java.util.List;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.vo.MenuInputVo;

/**
 * 菜单服务
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public interface MenuService {

	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单信息
	 */
	void addMenu(TDotaMenuTd menu);

	/**
	 * 获取菜单信息
	 * 
	 * @param menuId 菜单ID
	 * @return 菜单信息
	 */
	TDotaMenuTd getMenu(Integer menuId);

	/**
	 * 修改菜单信息
	 * 
	 * @param menu 菜单信息
	 */
	void updateMenu(TDotaMenuTd menu);

	/**
	 * 获取系统所有菜单，用于给角色分配菜单
	 * 
	 * @return 系统所有菜单
	 */
	List<TDotaMenuTd> getAllMenus();

	/**
	 * 查询菜单列表
	 * 
	 * @param input 菜单查询条件
	 * @return 统一分页结果
	 */
	PageResult<TDotaMenuTd> getMenuList(MenuInputVo input);

}
