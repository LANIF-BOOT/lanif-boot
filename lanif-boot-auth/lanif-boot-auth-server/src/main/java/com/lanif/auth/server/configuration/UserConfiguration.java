package com.lanif.auth.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 */
@Configuration
public class UserConfiguration {
    @Value("${jwt.token-header}")
    private String userTokenHeader;

	/**
	 * @return the userTokenHeader
	 */
	public String getUserTokenHeader() {
		return userTokenHeader;
	}

	/**
	 * @param userTokenHeader the userTokenHeader to set
	 */
	public void setUserTokenHeader(String userTokenHeader) {
		this.userTokenHeader = userTokenHeader;
	}
}
