package com.sebadev.bookAPISpringBoot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Book REST API", version = "1.0", description = "Basic CRUD operations on a single Book table"))
public class BookApiSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiSpringBootApplication.class, args);
	}

}
