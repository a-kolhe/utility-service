package com.working.utility_service;
import org.springframework.core.env.Environment;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = "com.working.utility_service.entities")
public class UtilityServiceApplication {

	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(UtilityServiceApplication.class, args);
	}

	@PostConstruct
	public void logAuthConfig() {
		System.out.println("🔐 Auth DB URL: " + env.getProperty("spring.datasource.url"));
		System.out.println("🧩 App Name: " + env.getProperty("spring.application.name"));
		System.out.println("🚀 Active Profiles: " + Arrays.toString(env.getActiveProfiles()));
	}

}
