/**
 * 
 */
package org.cloud.app.forum.common;

import java.io.Serializable;
import java.util.List;

/**
 * 统一分页结果
 * 
 * @author zhairp
 * @date 2018年8月6日
 * @since JDK1.8
 */
public class PageResult<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 分页数据
	 */
	private List<T> rows;

	/**
	 * @param rows
	 * @param data
	 */
	public PageResult(Integer total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

}
