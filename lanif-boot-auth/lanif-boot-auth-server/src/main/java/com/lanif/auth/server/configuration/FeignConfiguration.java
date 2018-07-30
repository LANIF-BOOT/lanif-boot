package com.lanif.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lanif.auth.server.interceptor.ClientTokenInterceptor;

/**
 */
@Configuration
public class FeignConfiguration {
    @Bean
    ClientTokenInterceptor getClientTokenInterceptor(){
        return new ClientTokenInterceptor();
    }
}
