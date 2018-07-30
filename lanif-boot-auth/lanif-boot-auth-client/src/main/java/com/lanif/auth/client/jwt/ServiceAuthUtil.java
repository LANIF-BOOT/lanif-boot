
package com.lanif.auth.client.jwt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.lanif.auth.client.config.ServiceAuthConfig;
import com.lanif.auth.client.feign.ServiceAuthFeign;
import com.lanif.auth.common.util.jwt.IJWTInfo;
import com.lanif.auth.common.util.jwt.JWTHelper;
import com.lanif.common.exception.auth.ClientTokenException;
import com.lanif.common.msg.BaseResponse;
import com.lanif.common.msg.ObjectRestResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

/**
 */
@Configuration
@EnableScheduling
public class ServiceAuthUtil{
	private static Logger log = LoggerFactory.getLogger(ServiceAuthUtil.class);
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    private List<String> allowedClient;
    private String clientToken;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new ClientTokenException("Client token expired!");
        } catch (SignatureException ex) {
            throw new ClientTokenException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new ClientTokenException("Client token is null or empty!");
        }
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient() {
        log.debug("refresh allowedClient.....");
        BaseResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            this.allowedClient = allowedClient.getData();
        }
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void refreshClientToken() {
        log.debug("refresh client token.....");
        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
            this.clientToken = clientToken.getData();
        }
    }


    public String getClientToken() {
        if (this.clientToken == null) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }
}