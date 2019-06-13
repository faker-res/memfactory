/**
 * 
 */
package org.cloud.app.forum.common;

import java.io.Serializable;

import org.cloud.app.forum.constant.IndexConstant;

/**
 * 统一分页条件
 * 
 * @author zhairp
 * @date 2018年8月6日
 * @since JDK1.8
 */
public class PageCondition implements Serializable {
	/**
	 * 
	 */
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

	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		if (pageIndex <= 0) {
			pageIndex = IndexConstant.DEFAULT_PAGE_INDEX;
		}
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		if (pageSize <= 0) {
			pageSize = IndexConstant.DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
