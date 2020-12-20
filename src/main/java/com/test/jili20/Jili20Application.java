package com.test.jili20;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.test.jili20.mapper")
@ComponentScan(basePackages = {"com.test"})
public class Jili20Application {

    public static void main(String[] args) {
        SpringApplication.run(Jili20Application.class, args);
    }

}
