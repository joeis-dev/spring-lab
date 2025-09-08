package dev.joeis.spring.basics.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    /**
     * A better and scalable aproach is to create a centralized class with
     * @ConfigurationPrefix(prefix="app.package.value") with their setters and getters so it will handle
     * all values in app.package.*
     * https://docs.spring.io/spring-boot/reference/features/external-config.html
     * */
    @Value("${app.env}")
    String environment;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World from "+ environment + "!";
    }
}
