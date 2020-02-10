package com.appcourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("----------Running Application Courses---------------");
		SpringApplication.run(Application.class, args);
	}
}
