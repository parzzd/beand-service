package com.hampcode.bankingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BeandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeandServiceApplication.class, args);
	}

}
