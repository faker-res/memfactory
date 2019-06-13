/**
 * 
 */
package org.cloud.app.forum.vo;

import org.cloud.app.forum.common.PageCondition;

/**
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public class MenuInputVo extends PageCondition {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单名称
	 */
	private String menuName;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
