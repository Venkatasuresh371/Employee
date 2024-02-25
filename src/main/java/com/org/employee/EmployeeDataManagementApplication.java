package com.org.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

/*import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

@SpringBootApplication
//@EnableSwagger2
public class EmployeeDataManagementApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeDataManagementApplication.class, args);
	}

//	@Bean
//	public Docket restApi()
//	{
//		Docket docket = new Docket(DocumentationType.SWAGGER_2)
//				.groupName("Employee Data API")
//				.apiInfo(apiInfo())
//				.select().build();
//		return docket;	
//	}
//
//	private ApiInfo apiInfo() 
//	{
//		 ApiInfo apiInfo = new ApiInfoBuilder()
//				.title("Employee Data Management ")
//				.description("Service API")
//				.termsOfServiceUrl("http://springfox.io")
//				.contact(new Contact("springfox", "", ""))
//				.license("Apache License Version 2.0")
//				.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
//				.version("2.0")
//				.build();
//		 return apiInfo;
//	}
}