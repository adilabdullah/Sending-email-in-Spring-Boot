package com.spring.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SendSmsEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendSmsEmailApplication.class, args);
	}

}
