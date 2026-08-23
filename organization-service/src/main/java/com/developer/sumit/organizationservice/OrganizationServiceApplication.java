package com.developer.sumit.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service Rest APIs",
				description = "Organization Service Rest APIs documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sumit",
						email = "sumit5507kr@gmail.com",
						url = "https://sumit-7055.github.io/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://sumit-7055.github.io/"
				)
		)
)
@SpringBootApplication
//@EnableEurekaClient
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
