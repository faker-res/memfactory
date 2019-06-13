/**
 * 
 */
package com.memfactory.article.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memfactory.article.exception.ParamIsNullException;

/**
 * @author zhairp createDate: 2019-02-13
 */
@RestController
public class ExceptionController {

	@GetMapping("exception1")
	public Object exception1() {
		return new RuntimeException("全局异常");
	}

	@GetMapping("exception2")
	public Object exception2() {
		return new ParamIsNullException("userId", "String");
	}

}
