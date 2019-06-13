/**
 * 
 */
package com.memfactory.article.vo;

import java.util.List;

import com.memfactory.pub.commom.PageCondition;
import com.memfactory.pub.commom.SortMethod;

/**
 * @author zhairp
 * @date 2018年8月22日
 * @since 0.0.1
 */
public class EssayQueryVo extends PageCondition {
	private static final long serialVersionUID = 1L;
	/**
	 * 栏目ID
	 */
	private Long columnId;
	/**
	 * 排序方式
	 */
	private List<SortMethod> sorts;
	/**
	 * 限制条数
	 */
	private String limit;

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public List<SortMethod> getSorts() {
		return sorts;
	}

	public void setSorts(List<SortMethod> sorts) {
		this.sorts = sorts;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "EssayQueryVo [columnId=" + columnId + ", sorts=" + sorts + ", limit=" + limit + "]";
	}

}
