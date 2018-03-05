package com.circumfusion;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationLauncher extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationLauncher.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
	}
	
	@Bean
	public DozerBeanMapper beanMapper() {
		return new DozerBeanMapper();
	}
	
}
