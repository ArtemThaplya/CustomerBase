package com.tsapliya.customerbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tsapliya.customerbase", "com.tsapliya.customerbase.controllers"})
public class CustomerBaseApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CustomerBaseApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerBaseApplication.class, args);
	}
}