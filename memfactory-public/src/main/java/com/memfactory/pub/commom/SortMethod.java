/**
 * 
 */
package com.memfactory.pub.commom;

/**
 * 排序类
 * 
 * @author zhairp
 * @since 0.0.1
 * createDate: 2018年8月30日
 */
public class SortMethod {

	/**
	 * 排序字段
	 */
	private String sortField;
	/**
	 * 排序方式 :DESC-降序 ASC-升序
	 */
	private String sortMode;

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortMode() {
		return sortMode;
	}

	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
	}

	@Override
	public String toString() {
		return "SortMethod [sortField=" + sortField + ", sortMode=" + sortMode + "]";
	}

}
