package com.ControlScholarAPI;

import com.ControlScholarAPI.constant.LearningCenterLocations;
import com.ControlScholarAPI.constant.Roles;
import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.service.LearningCenterService;
import com.ControlScholarAPI.service.LibraryManagerService;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@SpringBootApplication
public class ControlScholarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlScholarApiApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000/").allowedMethods("PUT", "POST", "GET", "DELETE");
            }
        };
    }

    @Bean
    CommandLineRunner run(MemberService memberService, LearningCenterService learningCenterService,
                          LibraryManagerService libraryManagerService){
        return args -> {
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Amecameca"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Atlacomulco"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Ecatepec"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Temascaltepec"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Tenalcingo"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Teotihuacan"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Texcoco"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "ValleDeChalco"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "ValleDeMexico"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Zumpango"));
            learningCenterService.saveLearningCenter(new LearningCenter(null, "Nezahualcoyotl"));

            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(0) + " " + Roles.privilegeRoles.get(0), "MALI1", learningCenterService.getLearningCenters().get(0)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "b@gmail.com",
                    "password", Roles.locationRoles.get(1) + " " + Roles.privilegeRoles.get(0), "MALI2", learningCenterService.getLearningCenters().get(1)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "b@gmail.com",
                    "password", Roles.locationRoles.get(1) + " " + Roles.privilegeRoles.get(2), "MALIX1", learningCenterService.getLearningCenters().get(1)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(2) + " " + Roles.privilegeRoles.get(0), "MALI3", learningCenterService.getLearningCenters().get(2)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(3) + " " + Roles.privilegeRoles.get(0), "MALI4", learningCenterService.getLearningCenters().get(3)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(4) + " " + Roles.privilegeRoles.get(0), "MALI5", learningCenterService.getLearningCenters().get(4)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(5) + " " + Roles.privilegeRoles.get(0), "MALI6", learningCenterService.getLearningCenters().get(5)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(6) + " " + Roles.privilegeRoles.get(0), "MALI7", learningCenterService.getLearningCenters().get(6)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(7) + " " + Roles.privilegeRoles.get(0), "MALI8", learningCenterService.getLearningCenters().get(7)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(8) + " " + Roles.privilegeRoles.get(0), "MALI9", learningCenterService.getLearningCenters().get(8)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(9) + " " + Roles.privilegeRoles.get(0), "MALI10", learningCenterService.getLearningCenters().get(9)));
            memberService.saveMember(new Member(null, "Smith", "Agente", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(10) + " " + Roles.privilegeRoles.get(0), "MALI11", learningCenterService.getLearningCenters().get(10)));


            libraryManagerService.saveBook(new Book(null, "El unico libro de la uni", "Bob Esponja", "1", "Crustaceo Cascarudo", 2033));
            libraryManagerService.saveBook(new Book(null, "Ingenieria", "Bob Esponja", "1", "Crustaceo Cascarudo", 2033));
            libraryManagerService.saveBook(new Book(null, "Psicologia", "Bob Esponja", "1", "Crustaceo Cascarudo", 2033));

            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(0), 1));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(1), 2));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(1), learningCenterService.getLearningCenters().get(1), 10));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(2), learningCenterService.getLearningCenters().get(1), 20));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(2), 3));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(3), 4));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(4), 5));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(5), 6));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(6), 7));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(7), 8));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(8), 9));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(9), 10));
            libraryManagerService.saveBookCopies(new BookCopies(null, libraryManagerService.getBooks().get(0), learningCenterService.getLearningCenters().get(10), 11));

            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Medios Alternos de Solucion de Conflictos"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Negocios Internacionales"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Mercadotecnia"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Informatica Administrativa"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Gastronomia"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Economia"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Derecho Internacional"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Derecho"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Ingenieria en Computacion"));
            learningCenterService.saveDegree(new Degree(null, "Licenciatura en Computacion"));

            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(0)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(1)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(2)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(3)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(4)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(5)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(6)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(7)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(8)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(0), learningCenterService.getDegrees().get(9)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(1), learningCenterService.getDegrees().get(9)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(1), learningCenterService.getDegrees().get(8)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(1), learningCenterService.getDegrees().get(7)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(2), learningCenterService.getDegrees().get(2)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(2), learningCenterService.getDegrees().get(4)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(3), learningCenterService.getDegrees().get(5)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(4), learningCenterService.getDegrees().get(2)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(5), learningCenterService.getDegrees().get(7)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(6), learningCenterService.getDegrees().get(5)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(7), learningCenterService.getDegrees().get(3)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(8), learningCenterService.getDegrees().get(1)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(9), learningCenterService.getDegrees().get(0)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(10), learningCenterService.getDegrees().get(9)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(10), learningCenterService.getDegrees().get(5)));
            learningCenterService.saveLearningCenterDegree(new LearningCenterDegree(
                    null, learningCenterService.getLearningCenters().get(10), learningCenterService.getDegrees().get(1)));

            memberService.saveMember(new Member(null, "Slave", "Slave", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(1) + " " + Roles.privilegeRoles.get(1), "curp1", learningCenterService.getLearningCenters().get(1)));
            memberService.saveMember(new Member(null, "Slave", "Slave", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(1) + " " + Roles.privilegeRoles.get(1), "curp2", learningCenterService.getLearningCenters().get(1)));
            memberService.saveMember(new Member(null, "Slave", "Slave", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(0) + " " + Roles.privilegeRoles.get(1), "curp3", learningCenterService.getLearningCenters().get(0)));
            memberService.saveMember(new Member(null, "Slave", "Slave", "Matrix", "a@gmail.com",
                    "password", Roles.locationRoles.get(0) + " " + Roles.privilegeRoles.get(1), "curp4", learningCenterService.getLearningCenters().get(0)));

            memberService.saveEnrollLearningCenterDegree(new EnrollLearningCenterDegree(null, learningCenterService.getLearningCenterDegreesByLearningCenter(memberService.getMemberByCurp("curp1").getLearningCenter()).get(0), memberService.getMemberByCurp("curp1"),false));
            memberService.saveEnrollLearningCenterDegree(new EnrollLearningCenterDegree(null, learningCenterService.getLearningCenterDegreesByLearningCenter(memberService.getMemberByCurp("curp2").getLearningCenter()).get(0), memberService.getMemberByCurp("curp2"),false));
            memberService.saveEnrollLearningCenterDegree(new EnrollLearningCenterDegree(null, learningCenterService.getLearningCenterDegreesByLearningCenter(memberService.getMemberByCurp("curp3").getLearningCenter()).get(0), memberService.getMemberByCurp("curp3"),false));
            memberService.saveEnrollLearningCenterDegree(new EnrollLearningCenterDegree(null, learningCenterService.getLearningCenterDegreesByLearningCenter(memberService.getMemberByCurp("curp4").getLearningCenter()).get(0), memberService.getMemberByCurp("curp4"),false));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
