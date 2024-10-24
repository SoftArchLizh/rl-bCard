package com.rongl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: 李中华
 * Date: 2024/10/24 8:53
 **/
@SpringBootApplication
@MapperScan("com.rongl.*")
public class AIBCardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AIBCardServiceApplication.class, args);
    }
}
