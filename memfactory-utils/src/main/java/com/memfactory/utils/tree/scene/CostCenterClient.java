package com.memfactory.utils.tree.scene;

import java.util.ArrayList;
import java.util.List;

import com.memfactory.utils.tree.bean.TreeNode;

/**
 * @author zhairp
 * createDate: 2018-09-04
 */
public class CostCenterClient {

	public static void main(String[] args) {
		// 第一步:自定义节点实体-给出判断是根节点的依据和子节点排序规则
		// 第二步:节点实现类-给出查询节点的实现
		CostCenterNodeService service = new CostCenterNodeService();
		// 模拟全文检索匹配叶子节点
		List<TreeNode> leafNodes = new ArrayList<TreeNode>();
		leafNodes.add(new CostCenterNode(100011L, "100011LNM", 1000L, false));
		leafNodes.add(new CostCenterNode(10001010L, "10001010LNM", 100010L, false));
		leafNodes.add(new CostCenterNode(1000101101L, "1000101101LNM", 10001011L, false));
		TreeNode tree = service.generateTree(leafNodes);
	}

}
