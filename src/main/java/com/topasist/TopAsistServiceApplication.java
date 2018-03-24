package com.topasist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.topasist")
public class TopAsistServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopAsistServiceApplication.class, args);
    }
}
