package com.TechIntPractice.ApolloDemo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApolloDemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApolloDemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		app.run(args);
		//SpringApplication.run(ApolloDemoApplication.class, args);
	}

}
