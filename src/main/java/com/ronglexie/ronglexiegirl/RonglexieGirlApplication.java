package com.ronglexie.ronglexiegirl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RonglexieGirlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RonglexieGirlApplication.class, args);
	}
}
