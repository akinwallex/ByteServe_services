package com.servbyte.DeliveryService;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliveryServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryServiceApiApplication.class, args);
	}
}
