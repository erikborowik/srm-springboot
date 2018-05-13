package com.srm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {  "com.srm.model" })
@EnableJpaRepositories(basePackages = { "com.srm.data.repository"})
public class SrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrmApplication.class, args);
	}
}
