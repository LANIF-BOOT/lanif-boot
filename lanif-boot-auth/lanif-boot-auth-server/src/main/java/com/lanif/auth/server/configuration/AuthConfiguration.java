package com.lanif.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lanif.common.handler.GlobalExceptionHandler;

/**
 */
@Configuration
public class AuthConfiguration {
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
