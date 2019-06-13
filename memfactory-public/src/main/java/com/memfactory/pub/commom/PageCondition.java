/**
 * 
 */
package com.memfactory.pub.commom;

import java.io.Serializable;

import com.memfactory.pub.constant.IndexConstant;

/**
 * 统一分页条件
 * 
 * @author zhairp
 * @since 0.0.1
 * createDate: 2018-08-30
 */
public class PageCondition implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 第几页，默认第一页
	 */
	private int pageIndex;
	/**
	 * 一页显示多少条，默认15条
	 */
	private int pageSize;

	/**
	 * 行号，Mysql从0开始.
	 */
	private int rowIndex;

	public int getRowIndex() {
		rowIndex = (getPageIndex() - 1) * getPageSize();
		return rowIndex;
	}

	public int getPageIndex() {
		if (pageIndex <= 0) {
			pageIndex = IndexConstant.DEFAULT_PAGE_INDEX;
		}
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		if (pageSize <= 0) {
			pageSize = IndexConstant.DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
