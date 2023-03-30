package com.grupo4grupo1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EquiposBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquiposBackendApplication.class, args);
	}

}
