package com.abc.template.health;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author zhairp createDate: 2018-11-01
 */
@RestController
public class HealthCheckController {

	@GetMapping(value = "/healthCheck")
	public Object healthCheck() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "OK");
		return map;
	}

}
