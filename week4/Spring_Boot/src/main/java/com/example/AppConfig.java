package com.example;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Configuration
@ComponentScan(basePackages="com.example")
@EnableAutoConfiguration
public class AppConfig {
}

