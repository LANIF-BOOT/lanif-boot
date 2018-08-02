package com.lanif.gateway.component.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanif.common.constant.CommonConstant;
import com.lanif.common.util.R;
import com.lanif.common.util.exception.PigDeniedException;

import lombok.extern.slf4j.Slf4j;

/**
 * 授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler
 * 包装失败信息到PigDeniedException
 */
@Slf4j
@Component
public class PigAccessDeniedHandler extends OAuth2AccessDeniedHandler {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 授权拒绝处理，使用R包装
     *
     * @param request       request
     * @param response      response
     * @param authException authException
     * @throws IOException      IOException
     * @throws ServletException ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        log.info("授权失败，禁止访问 {}", request.getRequestURI());
        response.setCharacterEncoding(CommonConstant.UTF8);
        response.setContentType(CommonConstant.CONTENT_TYPE);
        R<String> result = new R<>(new PigDeniedException("授权失败，禁止访问"));
        response.setStatus(HttpStatus.SC_FORBIDDEN);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(result));
    }
}
