package com.gz.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class ManagerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger("test");

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);


	}
}

