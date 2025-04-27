package com.sunil_spring_demo.Spring_002;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring002Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring002Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			System.out.println("Hello!");
		};
	}
}
