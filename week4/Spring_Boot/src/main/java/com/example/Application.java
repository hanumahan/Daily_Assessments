package com.example;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AppConfig.class)
            .web(WebApplicationType.SERVLET)
            .run(args);

        System.out.println("Spring Boot application started successfully.");
    }
}

