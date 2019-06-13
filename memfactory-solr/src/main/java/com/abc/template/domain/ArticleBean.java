/**
 * 
 */
package com.abc.template.domain;

import org.apache.solr.client.solrj.beans.Field;

import lombok.Data;

/**
 * @author zhairp createDate: 2018-11-12
 */
@Data
public class ArticleBean {

	@Field
	private Long id;

	@Field("a_title")
	private String title;

	@Field("pic_url")
	private String picUrl;

	@Field("a_content")
	private String content;

	@Field("column_id")
	private Integer columnId;

	@Field("a_source")
	private String source;

	@Field("source_url")
	private String sourceUrl;

	@Override
	public String toString() {
		return "ArticleBean [id=" + id + ", title=" + title + ", picUrl=" + picUrl + ", content=" + content + ", columnId=" + columnId + ", source=" + source + ", sourceUrl=" + sourceUrl + "]";
	}

}
