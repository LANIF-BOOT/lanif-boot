package com.lanif.auth.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lanif.auth.common.util.jwt.IJWTInfo;
import com.lanif.auth.server.configuration.UserConfiguration;
import com.lanif.auth.server.util.user.JwtTokenUtil;
import com.lanif.common.context.BaseContextHandler;

/**
 * Created by ace on 2017/9/10.
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserConfiguration userConfiguration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String token = request.getHeader(userConfiguration.getUserTokenHeader());
        IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
        BaseContextHandler.setUsername(infoFromToken.getUniqueName());
        BaseContextHandler.setName(infoFromToken.getName());
        BaseContextHandler.setUserID(infoFromToken.getId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
