package com.lanif.auth.config;

import lombok.Data;

/**
 * social 登录基础配置
 */
@Data
public class SocialPropertiesConfig {
    /**
     * 提供商
     */
    private String providerId;
    /**
     * 应用ID
     */
    private String clientId;
    /**
     * 应用密钥
     */
    private String clientSecret;

}
