package com.cflox.number_converter.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docketConfiguraion() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api"))
				.apis(RequestHandlerSelectors.basePackage("com.cflox.number_converter")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Number Converter", "cflox Assestment", "1.0", "open",
				new springfox.documentation.service.Contact("Tomiwa Ayeni", "http://abc.com",
						"ayeni.tomiwa.pudens@gmail.com"),
				"API Licence", "API Licence", Collections.emptyList());
	}
}
