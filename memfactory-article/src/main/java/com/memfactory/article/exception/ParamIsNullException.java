/**
 * 
 */
package com.memfactory.article.exception;

import lombok.Data;

/**
 * 参数为空异常
 * 
 * @author zhairp createDate: 2018-11-28
 */
@Data
public class ParamIsNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String parameterName;
	private final String parameterType;

	public ParamIsNullException(String parameterName, String parameterType) {
		super("");
		this.parameterName = parameterName;
		this.parameterType = parameterType;
	}

	@Override
	public String getMessage() {
		return "Required " + this.parameterType + " parameter \'" + this.parameterName + "\' must be not null !";
	}

}
