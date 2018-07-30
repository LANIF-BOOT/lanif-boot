package com.lanif.auth.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lanif.auth.server.service.AuthService;
import com.lanif.auth.server.util.user.JwtAuthenticationRequest;
import com.lanif.common.msg.ObjectRestResponse;

@RestController
@RequestMapping("jwt")
public class AuthController {
	private Logger log  = LoggerFactory.getLogger(AuthController.class);
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        log.info(authenticationRequest.getUsername()+" require logging...");
        final String token = authService.login(authenticationRequest);
        return new ObjectRestResponse<>().data(token);
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ObjectRestResponse<String> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return new ObjectRestResponse<>().data(refreshedToken);
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ObjectRestResponse<?> verify(String token) throws Exception {
        authService.validate(token);
        return new ObjectRestResponse<>();
    }
}
