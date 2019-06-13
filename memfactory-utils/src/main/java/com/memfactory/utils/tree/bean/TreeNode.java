package com.memfactory.utils.tree.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 * 
 * @author zhairp
 * createDate: 2018-09-04
 */
public abstract class TreeNode {
	private Long id;
	private String name;
	private Long parentId;
	private boolean directory; // 是否目录，否的话一定没有下级
	private List children = new ArrayList<>();

	public TreeNode(Long id, String name, Long parentId, boolean directory) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.directory = directory;
	}

	public TreeNode() {
		super();
	}

	/**
	 * 是否为根节点 根据当前节点的parentId判断该节点是否为根节点
	 *
	 * @param parentId
	 * @return
	 */
	public abstract boolean isRoot(Long parentId);

	/**
	 * 子节点排序
	 *
	 * @param children
	 */
	public abstract void sortChildren(List children);

	public void addChildNode(TreeNode treeNode) {
		children.add(treeNode);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public boolean isDirectory() {
		return directory;
	}

	public void setDirectory(boolean directory) {
		this.directory = directory;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

}
