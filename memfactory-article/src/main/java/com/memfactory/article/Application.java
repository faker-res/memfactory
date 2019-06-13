/**
 * 
 */
package com.memfactory.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhairp
 * @date 2018年8月21日
 * @since 0.0.1
 */
@EnableScheduling
@EnableCaching
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@RestController
public class Application {
	private Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("index")
	public String index() {
		log.info("hello world!");
		return "hello world!";
	}

	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> {
	 * log.info("Let's inspect the beans provided by Spring Boot:"); String[]
	 * beanNames = ctx.getBeanDefinitionNames(); Arrays.sort(beanNames); for (String
	 * beanName : beanNames) { log.info(beanName); }
	 * log.info("--------------------------end:{}-------------------",
	 * beanNames.length); }; }
	 */

}
