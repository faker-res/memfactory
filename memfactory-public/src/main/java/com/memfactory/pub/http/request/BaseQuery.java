/**
 * 
 */
package com.memfactory.pub.http.request;

import lombok.Data;

/**
 * 统一分页条件
 * 
 * @author zhairp createDate: 2019-04-22
 */
@Data
public abstract class BaseQuery {
	/**
	 * 第几页，从1开始
	 */
	private Integer pageIndex;
	/**
	 * 一页显示多少条
	 */
	private Integer pageSize;
}
