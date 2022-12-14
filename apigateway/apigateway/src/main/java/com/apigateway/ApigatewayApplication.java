package com.apigateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.netty.http.client.HttpClient;



@SpringBootApplication
@EnableEurekaClient
@CrossOrigin
public class ApigatewayApplication {



	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}



}
