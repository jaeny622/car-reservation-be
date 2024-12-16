package com.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VideoHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoHandlingApplication.class, args);
		System.out.println("HELLO");
	}

}
