package com.example.accommodation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccommodationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationApplication.class, args);
	}

}
