package com.authorization;

import com.authorization.models.User;
import com.authorization.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class AuthorizationServiceApplication implements CommandLineRunner {

	@Autowired
	UserDetailsRepository userDetailsRepository;


	@Bean

	public RestTemplate restTemplate(){return new RestTemplate();};










	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Authorization Service Started on Port Number: 8088");
	}
}
