package com.cybage.SecretSanta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages="com.cybage")
@EnableJpaRepositories(basePackages="com.cybage")
@EntityScan("com.cybage.model")
public class SecretSantaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SecretSantaApplication.class, args);
	}

}
