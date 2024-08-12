package com.ovium.restfulservices.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
//@Import(BeanValidatorPluginsConfiguration.class) // will pull limitation from User and Order POJO
public class SwaggerConfig {

	/*
	 * @Bean public Docket api() {
	 * 
	 * return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
	 * .apis(RequestHandlerSelectors.basePackage(
	 * "com.ovium.restfulservices.controller"))
	 * .paths(PathSelectors.ant("/users/**")).build(); // .paths(regex("/users.*"))
	 * // .paths(PathSelectors.ant("/users/**")).build();
	 * 
	 * return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.ovium.restfulservices"))
	 * .paths(PathSelectors.ant("/users/**")).build();
	 * 
	 * }
	 */

	/*
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage(
	 * "com.ovium.restfulservices.controller"))
	 * .paths(PathSelectors.any()).build().apiInfo(getApiInfo()); }
	 */

	// Swagger Metadata: http://localhost:8080/v2/api-docs
	// Swagger UI URL: http://localhost:8080/swagger-ui.html

	/*
	 * private ApiInfo getApiInfo() { return new
	 * ApiInfoBuilder().title("StackSimplify User Management Service")
	 * .description("This page lists all API's of User Management").version("2.0")
	 * .contact(new Contact("Kalyan Reddy", "https://www.stacksimplify.com",
	 * "joblovely@gmail.com")) .license("License 2.0").licenseUrl(
	 * "https://www.stacksimplify.com/license.html").build(); }
	 */

	// Swagger Metadata: http://192.168.0.100:8080/v2/api-docs
	// swagger UI URL: http://192.168.0.100:8080/swagger-ui.html

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("User and Order By Kalyan Udemy System")
				.description("This page lists all API's in System").version("V2.0").contact(new Contact("Yogiraj Patil",
						"https://yogiraj80555.github.io/YogirajPortfolio/", "yogiraj.218m0064@viit.ac.in"))
				.license("under MIT License").build();
	}
}
