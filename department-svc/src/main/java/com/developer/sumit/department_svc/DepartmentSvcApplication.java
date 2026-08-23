package com.developer.sumit.department_svc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info= @Info(
				title = "Department Service Rest APIs",
				description = "Department Service Rest APIs Documentation",
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
public class DepartmentSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentSvcApplication.class, args);
	}

}
