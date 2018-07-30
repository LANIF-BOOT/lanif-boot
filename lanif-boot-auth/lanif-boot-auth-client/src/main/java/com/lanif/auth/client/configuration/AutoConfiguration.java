package com.lanif.auth.client.configuration;

import com.lanif.auth.client.config.ServiceAuthConfig;
import com.lanif.auth.client.config.UserAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 */
@Configuration
@ComponentScan({ "com.lanif.auth.client", "com.lanif.auth.common.event" })
public class AutoConfiguration {
	@Bean
	ServiceAuthConfig getServiceAuthConfig() {
		return new ServiceAuthConfig();
	}

	@Bean
	UserAuthConfig getUserAuthConfig() {
		return new UserAuthConfig();
	}

}
