package com.isa.fishingbooker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isa.fishingbooker.model.Client;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FishingBookerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishingBookerApplication.class, args);
		
	}

}
