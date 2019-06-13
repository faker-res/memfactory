package com.memfactory.utils.tree.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.memfactory.utils.tree.bean.TreeNode;

/**
 * 树生成helper
 * 
 * @author zhairp
 * createDate: 2018-09-04
 */
public class TreeHelper {

	/**
	 * 处理叶子以及相关的节点组
	 * 
	 * @param nodeMap 叶子以及相关的节点组
	 */
	public static <T extends TreeNode> void generateTree(Map<Long, T> nodeMap) {
		// 建立父子关系
		for (TreeNode node : nodeMap.values()) {
			Long parentId = node.getParentId();
			if (node.isRoot(parentId)) {
				continue;
			}
			if (nodeMap.containsKey(parentId)) {
				TreeNode parentNode = nodeMap.get(parentId);
				if (parentNode == null) {
					throw new RuntimeException("生成树失败");
				} else {
					parentNode.addChildNode(node);
				}
			}
		}
		// sort
		for (T t : nodeMap.values()) {
			List children = t.getChildren();
			if (children != null && children.size() > 0) {
				t.sortChildren(children);
			}
		}
	}

	/**
	 * 生成树结构
	 * 
	 * @param nodeMap 已经处理节点树
	 * @return 树结构
	 */
	public static <T extends TreeNode> TreeNode buildTree(Map<Long, T> nodeMap) {
		if (null != nodeMap && !CollectionUtils.isEmpty(nodeMap.values())) {
			Iterator<TreeNode> iterator = (Iterator<TreeNode>) nodeMap.values().iterator();
			while (iterator.hasNext()) {
				TreeNode o = iterator.next();
				if (o.isRoot(o.getParentId())) {
					return o;
				}
			}
		}
		return null;
	}
}
