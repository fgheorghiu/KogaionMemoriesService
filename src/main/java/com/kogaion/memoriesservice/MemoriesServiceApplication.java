package com.kogaion.memoriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.kogaion.digix.*")
@SpringBootApplication
public class MemoriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesServiceApplication.class, args);
	}

}
