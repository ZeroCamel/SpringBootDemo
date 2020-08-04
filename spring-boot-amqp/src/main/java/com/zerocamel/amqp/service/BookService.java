package com.zerocamel.amqp.service;

import com.zerocamel.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service
public class BookService {

    @RabbitListener(queues = "zerocamel.news")
    public void receive(Book book)
    {
        out.println("收到消息："+book);
    }

    @RabbitListener(queues = "zerocamel.news")
    public void receive(Message message)
    {
        out.println(message.getBody());
        out.println(message.getMessageProperties());
    }

}
