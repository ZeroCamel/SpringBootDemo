package com.zerocamel.providerticket.controller;

import com.zerocamel.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-cloud
 * @description: 控制器
 * @author: zeroCamel
 * @create: 2020-08-06 09:33
 **/
@RestController
public class TickertController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketService.getTicket();
    }
}
