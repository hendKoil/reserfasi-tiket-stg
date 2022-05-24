package com.challenge4.apichallenge4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableSwagger2
@SpringBootApplication

public class ApiChallenge4Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiChallenge4Application.class, args);
	}
//@Bean
//	PasswordEncoder passwordEncoder(){
//	return new BCryptPasswordEncoder();
//}

}
