package com.test.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Is a convenience Annotation thats combined: 1.@EnableAutoConfigeration 2.@ComponentScan 3.Configuration
public class TestCrud1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestCrud1Application.class, args);
		System.out.println("hello ratul");
		System.out.println("few");
	}

}
