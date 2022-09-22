package com.oop.napi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OopNapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OopNapiApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
