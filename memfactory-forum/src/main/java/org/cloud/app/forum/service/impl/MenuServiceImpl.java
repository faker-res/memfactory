/**
 * 
 */
package org.cloud.app.forum.service.impl;

import java.util.List;

import org.cloud.app.forum.bean.TDotaMenuTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.persistence.TDotaMenuTdMapper;
import org.cloud.app.forum.service.MenuService;
import org.cloud.app.forum.util.BaseDomainUtil;
import org.cloud.app.forum.vo.MenuInputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private TDotaMenuTdMapper tDotaMenuTdMapper;

	@Override
	public void addMenu(TDotaMenuTd menu) {
		BaseDomainUtil.setBaseDomain(menu);
		tDotaMenuTdMapper.insertSelective(menu);
	}

	@Override
	public TDotaMenuTd getMenu(Integer menuId) {
		return tDotaMenuTdMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public void updateMenu(TDotaMenuTd menu) {
		BaseDomainUtil.updateBaseDomain(menu);
		tDotaMenuTdMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public List<TDotaMenuTd> getAllMenus() {
		return tDotaMenuTdMapper.getAllMenus();
	}

	@Override
	public PageResult<TDotaMenuTd> getMenuList(MenuInputVo input) {
		Integer total = tDotaMenuTdMapper.getMenuListCnt(input);
		List<TDotaMenuTd> data = tDotaMenuTdMapper.getMenuListData(input);
		return new PageResult<TDotaMenuTd>(total, data);
	}

}
