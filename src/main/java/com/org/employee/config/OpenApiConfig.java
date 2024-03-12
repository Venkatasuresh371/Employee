package com.org.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig
{
	@Bean
    public OpenAPI clientOpenApi()
    {
    	return new OpenAPI()
    			.info(new Info().title("Employee Data Management")
    			.description("List of Api's for employee data management")		
    			.version("3.2.2"));
    }
}