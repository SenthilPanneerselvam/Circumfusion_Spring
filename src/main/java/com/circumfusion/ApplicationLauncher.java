package com.circumfusion;

import javax.servlet.Filter;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.circumfusion.filter.AuthenticationFilter;

@SpringBootApplication
public class ApplicationLauncher extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationLauncher.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
		//My test commit check
	}
	
	@Bean
	public DozerBeanMapper beanMapper() {
		return new DozerBeanMapper();
	}
	
}
