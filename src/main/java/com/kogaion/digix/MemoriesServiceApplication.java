package com.kogaion.digix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.kogaion.digix.*"})
@EnableAutoConfiguration
@SpringBootApplication
public class MemoriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesServiceApplication.class, args);
	}

}
