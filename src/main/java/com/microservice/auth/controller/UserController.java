package com.microservice.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Luis Gustavo Ullmann on 01/07/2020
 */
@RestController
public class UserController {
    //Principal é justamente os dados do usuário
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
