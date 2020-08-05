package com.zerocamel.task.controller;

import com.zerocamel.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-task
 * @description: 控制器
 * @author: zeroCamel
 * @create: 2020-08-05 13:50
 **/
@RestController
public class HelloController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/testAsync")
    public String testAsync()
    {
        asyncService.test();
        return "SUCCESS";
    }
}
