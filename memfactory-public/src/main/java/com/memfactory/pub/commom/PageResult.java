/**
 * 
 */
package com.memfactory.pub.commom;

import java.io.Serializable;
import java.util.List;

/**
 * 统一分页结果
 * 
 * @author zhairp
 * @since 0.0.1 
 * createDate: 2018年8月30日
 */
public class PageResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 分页数据
	 */
	private List<T> rows;

	public PageResult(Integer total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public List<T> getRows() {
		return rows;
	}

}
