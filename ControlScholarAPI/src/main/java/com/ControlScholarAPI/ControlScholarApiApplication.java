package com.ControlScholarAPI;

import com.ControlScholarAPI.model.LearningCenter;
import com.ControlScholarAPI.model.Member;
import com.ControlScholarAPI.service.LearningCenterService;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class ControlScholarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlScholarApiApplication.class, args);
	}

    @Bean
    CommandLineRunner run(MemberService memberService, LearningCenterService learningCenterService){
        return args -> {
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Atlacomulco"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Amecameca"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Ecatepec"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Temascaltepec"));

            memberService.saveMember(new Member(null, "Isaac", "Manjarrez", "Leyva", "saacmanjarrez@gmail.com",
                    "password", "ROLE_ATLACOMULCO ROLE_LIBRARY_MANAGER", learningCenterService.getLearningCenterById(1)));

        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
