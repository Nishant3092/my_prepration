package com.example.registrationlogindemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RegistrationLoginDemoApplication {

	 static final Logger logger = LoggerFactory.getLogger(RegistrationLoginDemoApplication.class);
	 
	public static void main(String[] args) {
		
		logger.info("Application started .................................");
		
		SpringApplication.run(RegistrationLoginDemoApplication.class, args);
	}

	
	
	
	
	
	
	
}
