package com.ControlScholarAPI;

import com.ControlScholarAPI.model.LearningCenter;
import com.ControlScholarAPI.model.Member;
import com.ControlScholarAPI.model.Role;
import com.ControlScholarAPI.service.LearningCenterService;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
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

            memberService.saveRole(new Role(null, "ROLE_LIBRARY_MANAGER"));
            memberService.saveRole(new Role(null, "ROLE_TOLUCA"));
            memberService.saveRole(new Role(null, "ROLE_ATLACOMULCO"));

            memberService.saveMember(new Member(null, "Isaac", "Manjarrez", "Leyva", "saacmanjarrez@gmail.com",
                    "password",
                    Set.of(memberService.getRole("ROLE_LIBRARY_MANAGER"), memberService.getRole("ROLE_ATLACOMULCO")),
                    learningCenterService.getLearningCenterById(1)));

        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
