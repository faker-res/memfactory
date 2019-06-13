package com.memfactory.pub.commom;

/**
 * 列实体
 * 
 * @author zhairp createDate: 2018-09-10
 */
public class Column {
	/**
	 * text eg 证券代码, 证券简称, 最新债项, 发行人最新评级
	 */
	private String title;
	/**
	 * code or column name of table
	 */
	private String column;

	public Column() {
	}

	public Column(String title, String column) {
		this.title = title;
		this.column = column;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

}
