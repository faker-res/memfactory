package com.memfactory.utils.tree.common;

import java.util.List;
import java.util.Map;

import com.memfactory.utils.tree.bean.TreeNode;

/**
 * 节点基础服务
 * 
 * @author zhairp createDate: 2018-09-04
 */
public interface NodeService {

	/**
	 * 查询节点
	 * 
	 * @param id 节点ID
	 * @return
	 * @return 节点实体
	 */
	TreeNode getNode(Long id);

	/**
	 * 存储叶子节点以及其父节点
	 * 
	 * @param leafNode 叶子节点
	 * @param target   存储叶子节点以及其父节点的容器
	 */
	void collectParentNodes(TreeNode leafNode, List<TreeNode> target);

	/**
	 * 获取叶子节点以及相关的父节点
	 * 
	 * @param leafNodes 叶子节点组
	 * @return 叶子节点以及相关的父节点组 键是节点ID，值是节点实体
	 */
	Map<Long, TreeNode> getRelativeNodes(List<TreeNode> leafNodes);

	/**
	 * 生成树
	 * 
	 * @param leafNodes 叶子节点
	 * @return 树结构
	 */
	TreeNode generateTree(List<TreeNode> leafNodes);

	/**
	 * 由叶子节点生成的树结构  createDate: 2018-09-11
	 * 
	 * @param child 叶子结点
	 * @return 由叶子节点生成的树结构
	 */
	TreeNode spanTree(TreeNode child);
}
