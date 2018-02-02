package com.ronglexie.ronglexiegirl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * Spring Boot启动类
 *
 * @author wxt.xqr
 * @version 2018-2-2
 */
@SpringBootApplication
@EnableCaching
public class RonglexieGirlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RonglexieGirlApplication.class, args);
	}
}
