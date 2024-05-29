package com.hampcode.bankingservice.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

public class OpenAPIConfig {
    @Value("${cashflow.openapi.dev-url}")
    private String devUrl;
    @Value("${cashflow.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI(){
        Server devServer=new Server(); 
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer=new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Development environment");
        Contact contact=new Contact();
        contact.setEmail("pedro@gmail.com");
        contact.setName("pedro");
        License mitLicense=new License().name("MIT License").url("https://choosealicense.com/license/mit/");
        Info info=new Info().title("API").version("1.0").contact(contact).license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(devServer,prodServer));
    }
}
