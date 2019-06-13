package com.memfactory.utils.tree.scene;

import java.util.Collections;
import java.util.List;

import com.memfactory.utils.tree.bean.TreeNode;


/**
 * @author zhairp
 * createDate: 2018-09-04
 */
public class CostCenterNode extends TreeNode implements Comparable<CostCenterNode> {

	public CostCenterNode(Long id, String name, Long parentId, boolean directory) {
		super(id, name, parentId, directory);
	}

	@Override
	public boolean isRoot(Long parentId) {
		if (parentId == 0L) {
			return true;
		}
		return false;
	}

	@Override
	public void sortChildren(List children) {
		Collections.sort(children);
	}

	@Override
	public int compareTo(CostCenterNode o) {
		return this.getId().compareTo(o.getId());
	}

}
