package com.example.springbootstartertest.contoller;

import com.example.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String Hello(){
        String sayHelloExample = helloService.sayHelloExample("hhh");
        return sayHelloExample;
    }
}
