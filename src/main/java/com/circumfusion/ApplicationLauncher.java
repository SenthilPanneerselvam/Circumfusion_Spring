package com.circumfusion;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ApplicationLauncher extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
	}
	
	@Bean
	public DozerBeanMapper beanMapper() {
		return new DozerBeanMapper();
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "HEAD", "POST", "DELETE", "OPTIONS", "PUT");
	}

}
