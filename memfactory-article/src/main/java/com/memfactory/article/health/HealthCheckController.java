/**
 * 
 */
package com.memfactory.article.health;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhairp createDate: 2018-11-13
 */
@RestController
public class HealthCheckController {

	@GetMapping("healthCheck")
	public Object healthCheck() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "OK");
		return map;
	}

}
