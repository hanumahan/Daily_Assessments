package week3.SpringSecurity;
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Webcontroller {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";  // Corresponds to /WEB-INF/views/hello.jsp
    }
}
