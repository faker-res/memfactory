package com.memfactory.pub.commom;

import java.util.List;
import java.util.Map;

/**
 * 表格
 * 
 * @author zhairp createDate: 2018-09-10
 */
public class TableData {
	/**
	 * eg 证券代码, 证券简称, 最新债项, 发行人最新评级
	 */
	private List<Column> headerOptions;

	/**
	 * eg 证券代码, 证券简称, 最新债项, 发行人最新评级
	 */
	private List<Column> headers;

	/**
	 * 数据总条数
	 * 
	 */
	private long total;
	/**
	 * 表格数据
	 */
	private List<Map<String, Object>> dataList;

	public List<Column> getHeaderOptions() {
		return headerOptions;
	}

	public void setHeaderOptions(List<Column> headerOptions) {
		this.headerOptions = headerOptions;
	}

	public List<Column> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Column> headers) {
		this.headers = headers;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Map<String, Object>> getDataList() {
		return dataList;
	}

	public void setDataList(List<Map<String, Object>> dataList) {
		this.dataList = dataList;
	}

}
