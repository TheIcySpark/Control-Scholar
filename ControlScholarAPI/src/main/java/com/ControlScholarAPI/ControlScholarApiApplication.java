package com.ControlScholarAPI;

import com.ControlScholarAPI.model.Member;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ControlScholarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlScholarApiApplication.class, args);
	}


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
