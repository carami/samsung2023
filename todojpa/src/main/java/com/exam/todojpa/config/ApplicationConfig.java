package com.exam.todojpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration 
@ComponentScan(basePackages = {"com.exam.todojpa.service"})
public class ApplicationConfig {
//	@Bean
//	public DataSource dataSource() {
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//		dataSource.setDriverClass(org.h2.Driver.class);
//		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("");		
//		return dataSource;
//	}
	
	
}
