package dev.joeis.spring.basics.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World from spring basics!";
    }
}
