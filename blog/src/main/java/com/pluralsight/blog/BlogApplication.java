package com.pluralsight.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		System.out.println("Main Application Call...............");
		SpringApplication.run(BlogApplication.class, args);
		
	}

	
}