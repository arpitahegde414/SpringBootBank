package com.example.AllicaBank;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Customer API",
				version = "1.0",
				description = "API for managing customers"
		)
)
public class AllicaBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(AllicaBankApplication.class, args);
	}
}
