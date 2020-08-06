package com.zerocamel.providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-cloud
 * @description: 票据服务
 * @author: zeroCamel
 * @create: 2020-08-06 09:31
 **/
@Service
public class TicketService {

    public String getTicket(){
        System.out.println("8002");
        return "《我的未来不迷茫》";
    }
}
