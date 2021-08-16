package application.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("application"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

	private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Products REST API",
                "REST API for product registration.",
                "1.0",
                "Terms of Service",
                new Contact("Anderson Santos", "https://github.com/AAndersonSantos/API-Rest-Products", "andersonsantos.inc01@gmail.com"),     
                "MIT License",
                "https://github.com/AAndersonSantos/API-Rest-Products/blob/main/LICENSE", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
