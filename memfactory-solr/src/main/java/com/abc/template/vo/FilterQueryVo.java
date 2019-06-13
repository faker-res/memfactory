/**
 * 
 */
package com.abc.template.vo;

import lombok.Data;

/**
 * @author zhairp createDate: 2018-11-09
 */
@Data
public class FilterQueryVo {

	private String core;

	private String q;

	private String sort;

	private Integer start;

	private Integer rows;

}
