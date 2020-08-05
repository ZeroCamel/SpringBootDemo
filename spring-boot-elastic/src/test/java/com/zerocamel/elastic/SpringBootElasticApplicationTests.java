package com.zerocamel.elastic;

import com.zerocamel.elastic.bean.Book;
import com.zerocamel.elastic.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootElasticApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {

        Book book = new Book();
        book.setId(1);
        book.setAuthor("");
        book.setBookName("jjj");

        bookRepository.save(book);

    }

}
