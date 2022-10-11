package com.spring.notification.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAsync
public class ApplicationConfiguration implements AsyncConfigurer{

	
	 @Bean(name = "threadPoolTaskExecutor1")
	 public Executor executor1() {
	  ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	  executor.setCorePoolSize(4);
	  executor.setMaxPoolSize(4);
	  executor.setQueueCapacity(50);
	  executor.setThreadNamePrefix("CustomExecutor1::");
	  executor.initialize();
	  return executor;
	 }
	 
	 
	  @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
