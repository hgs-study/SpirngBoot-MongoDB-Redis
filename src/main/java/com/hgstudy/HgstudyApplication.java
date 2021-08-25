package com.hgstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HgstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HgstudyApplication.class, args);
    }

}
