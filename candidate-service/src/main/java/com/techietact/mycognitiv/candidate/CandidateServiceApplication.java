package com.techietact.mycognitiv.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CandidateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateServiceApplication.class, args);
	}

}
