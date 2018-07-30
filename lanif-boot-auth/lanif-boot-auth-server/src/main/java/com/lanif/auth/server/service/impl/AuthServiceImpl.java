package com.lanif.auth.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lanif.api.vo.user.UserInfo;
import com.lanif.auth.common.util.jwt.JWTInfo;
import com.lanif.auth.server.feign.IUserService;
import com.lanif.auth.server.service.AuthService;
import com.lanif.auth.server.util.user.JwtAuthenticationRequest;
import com.lanif.auth.server.util.user.JwtTokenUtil;
import com.lanif.common.exception.auth.UserInvalidException;

@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        UserInfo info = userService.validate(authenticationRequest);
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public String refresh(String oldToken) throws Exception {
        return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
    }
}
