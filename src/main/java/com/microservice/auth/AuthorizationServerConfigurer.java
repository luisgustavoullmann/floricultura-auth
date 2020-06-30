package com.microservice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Created by Luis Gustavo Ullmann on 29/06/2020
 */
@Configuration
public class AuthorizationServerConfigurer  extends AuthorizationServerConfigurerAdapter {
    //Usuário final só precisa se autenticar uma vez no login da aplicação,
    // mas como é um microserviço, é preciso passar o token dizendo
    // se o usuário está mesmo logado em para cada requisição em um dos endpoints dos microserviços

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //O usuário da aplicação, precisa se autenticar na tela de login passando usuario e senha
    //Criando um acesso para loja
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //Metodo inMemory(), no build nos permite criar usuário e senhas de aplicações que ficarão em memória
        //toda vez que o usuário subir
        clients.inMemory()
                .withClient("loja")//usuario
                .secret(passwordEncoder.encode("lojapwd")) //senha
                .authorizedGrantTypes("password") //tipos de acesso que demos para aplicação
                .scopes("web", "mobile");
    }

    @Override //Unindo a autenticação ao user detail
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
