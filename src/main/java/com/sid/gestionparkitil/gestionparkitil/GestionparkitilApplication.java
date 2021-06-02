package com.sid.gestionparkitil.gestionparkitil;

import com.sid.gestionparkitil.gestionparkitil.Service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class GestionparkitilApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionparkitilApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            //accountService.addNewUser(new Utilisateur(0,"admin","amdin@gmail.com","passpass","0533025489",null,null,false));
        };
    }
}
