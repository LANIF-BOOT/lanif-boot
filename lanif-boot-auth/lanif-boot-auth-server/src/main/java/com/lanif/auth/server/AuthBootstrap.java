package com.lanif.auth.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.lanif.auth.server.mapper")
@EnableAutoConfiguration
public class AuthBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AuthBootstrap.class, args);
    }
}
