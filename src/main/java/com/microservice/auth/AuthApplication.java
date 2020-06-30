package com.microservice.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class AuthApplication {
    //Autenticação do repositório de REST-API é melhor explicado

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    //Principal é justamente os dados do usuário
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

}
