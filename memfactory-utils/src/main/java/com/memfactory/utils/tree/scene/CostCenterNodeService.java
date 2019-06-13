package com.memfactory.utils.tree.scene;

import java.util.HashMap;
import java.util.Map;

import com.memfactory.utils.tree.bean.TreeNode;
import com.memfactory.utils.tree.common.BaseNodeService;

/**
 * 具体场景实现类
 * 
 * @author zhairp
 * createDate: 2018-09-04
 */
public class CostCenterNodeService extends BaseNodeService {
	static Map<Long, CostCenterNode> nodeMap = new HashMap<Long, CostCenterNode>();

	static {
		// 模拟从数据库查询节点集合
		nodeMap.put(1000L, new CostCenterNode(1000L, "1000NM", 0L, true));
		nodeMap.put(100010L, new CostCenterNode(100010L, "100010LNM", 1000L, true));
		nodeMap.put(100011L, new CostCenterNode(100011L, "100011LNM", 1000L, false));
		nodeMap.put(10001010L, new CostCenterNode(10001010L, "10001010LNM", 100010L, false));
		nodeMap.put(10001011L, new CostCenterNode(10001011L, "10001011LNM", 100010L, true));
		nodeMap.put(1000101101L, new CostCenterNode(1000101101L, "1000101101LNM", 10001011L, false));
	}

	@Override
	public TreeNode getNode(Long id) {
		return nodeMap.get(id);
	}

}
