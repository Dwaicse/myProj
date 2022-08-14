package com.pensionerDetails;

import com.pensionerDetails.model.User;
import com.pensionerDetails.repositories.UserDetailsRepository;
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
public class PensionerDetailsApplication implements CommandLineRunner {

	@Autowired
	UserDetailsRepository userDetailsRepository;


	@Bean

	public RestTemplate restTemplate(){return new RestTemplate();};




	@PostConstruct
	public void initUsers(){
		User user = new User();
		user.setName("Admin");
		user.setEmailId("admin@penmanage.com");
		user.setUsername("pendetails01");
		user.setPassword("pendetails");
		user.setPhone(Long.parseLong("9874123456"));

		System.out.println("UserName: " +user.getUsername()+ " Password: "+user.getPassword());
		this.userDetailsRepository.save(user);

	}






	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		System.out.println("Starting Code");



	}

}
