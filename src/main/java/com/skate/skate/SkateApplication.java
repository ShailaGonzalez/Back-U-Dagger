package com.skate.skate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkateApplication.class, args);
		System.out.println("Hello Dagger! Welcome back!");
	}

}
