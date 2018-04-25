package com.example.moodsense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoMoodsenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMoodsenseApplication.class, args);
	}
}
