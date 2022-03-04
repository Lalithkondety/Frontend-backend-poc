package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses = RegistrationController.class)
//@ComponentScan(basePackageClasses = RegistrationService.class)
//@ComponentScan(basePackageClasses = RegistrationRepository.class)
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
