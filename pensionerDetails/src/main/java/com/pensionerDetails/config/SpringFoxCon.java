package com.pensionerDetails.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxCon {



    @Bean
    public Docket api(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.pensionerDetails"))
                 .paths(PathSelectors.any())
                 .build()
                 .apiInfo(apiDetails());



    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Pensioner Details API",
                "Api Endpoints for Pensioner Details Service",
                "1.0",
                "Free to use",
                new Contact("Dwaipayan Bhattacharya","http://dwaipayanbhatta.com","mailtodwai@gmail.com"),
                "API License",
                "http://dwaipayan.com/pensionManagement",
                Collections.emptyList()
        );
    }
}
