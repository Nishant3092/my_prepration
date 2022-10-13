package com.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.controller.EmployeesController;

@SpringBootApplication
public class NishSpringboot1Application {
	
	

	public static void main(String[] args) {
		System.out.println("Application Started Main Class Calling..............");
		SpringApplication.run(NishSpringboot1Application.class, args);
		
	}

}
