package com.lafiray.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootLafirayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLafirayAppApplication.class, args);
	}

}
