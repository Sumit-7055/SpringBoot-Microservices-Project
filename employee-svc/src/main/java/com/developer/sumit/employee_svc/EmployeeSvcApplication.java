package com.developer.sumit.employee_svc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(
		info= @Info(
				title = "Employee Service Rest APIs",
				description = "Employee Service Rest APIs Documentation",
				version = "v1.0,",
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
@EnableFeignClients
public class EmployeeSvcApplication {
//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeSvcApplication.class, args);
	}

}
