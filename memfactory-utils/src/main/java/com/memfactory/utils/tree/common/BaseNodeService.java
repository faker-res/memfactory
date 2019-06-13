package com.memfactory.utils.tree.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.memfactory.utils.tree.bean.TreeNode;
import com.memfactory.utils.tree.util.TreeHelper;

/**
 * 节点基础服务实现
 * 
 * @author zhairp createDate: 2018-09-04
 */
public abstract class BaseNodeService implements NodeService {

	@Override
	public void collectParentNodes(TreeNode leafNode, List<TreeNode> target) {
		target.add(leafNode);
		Long parentId = leafNode.getParentId();
		if (leafNode.isRoot(parentId)) {
			return;
		} else {
			TreeNode parentNode = getNode(parentId);
			collectParentNodes(parentNode, target);
		}
	}

	@Override
	public Map<Long, TreeNode> getRelativeNodes(List<TreeNode> leafNodes) {
		if (!CollectionUtils.isEmpty(leafNodes)) {
			List<TreeNode> tatalTarget = new ArrayList<TreeNode>();
			leafNodes.forEach(leafNode -> {
				List<TreeNode> target = new ArrayList<TreeNode>();
				collectParentNodes(leafNode, target);
				tatalTarget.addAll(target);
			});
			Map<Long, TreeNode> result = new HashMap<Long, TreeNode>();
			tatalTarget.forEach(node -> {
				result.put(node.getId(), node);
			});
			return result;
		}
		return null;
	}

	@Override
	public TreeNode generateTree(List<TreeNode> leafNodes) {
		if (!CollectionUtils.isEmpty(leafNodes)) {
			Map<Long, TreeNode> nodeMap = getRelativeNodes(leafNodes);
			TreeHelper.generateTree(nodeMap);
			return TreeHelper.buildTree(nodeMap);
		}
		return null;
	}

	@Override
	public TreeNode spanTree(TreeNode child) {
		if (null == child) {
			return null;
		}
		if (child.isRoot(child.getParentId())) {
			return child;
		} else {
			TreeNode parent = getNode(child.getParentId());
			parent.addChildNode(child);
			return spanTree(parent);
		}
	}

}
