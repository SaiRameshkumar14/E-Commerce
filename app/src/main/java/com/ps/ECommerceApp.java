package com.flex.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.flex.ps.controller", "com.flex.ps.service","com.flex.ps.repository.ProductRepository"}) // Add all relevant base packages
public class DayOneProductStoringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayOneProductStoringAppApplication.class, args);
	}

}
