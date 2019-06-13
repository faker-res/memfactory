/**
 * 
 */
package com.memfactory.pub.http.response;

import java.util.List;

import lombok.Data;

/**
 * 统一分页结果
 * 
 * @author zhairp createDate: 2019-04-22
 */
@Data
public class BaseResult<T> {
	/**
	 * 总记录数
	 */
	private Long total;
	/**
	 * 分页数据
	 */
	private List<T> rows;

	public BaseResult(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public BaseResult() {
		super();
	}

}
