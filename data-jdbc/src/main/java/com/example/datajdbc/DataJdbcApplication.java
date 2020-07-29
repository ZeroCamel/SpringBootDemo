package com.example.datajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class DataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJdbcApplication.class, args);
    }

}
