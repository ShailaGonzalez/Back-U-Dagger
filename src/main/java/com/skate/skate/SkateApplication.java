package com.skate.skate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SkateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkateApplication.class, args);
        System.out.println("Hello Dagger! Welcome back!");
    }
}
