package com.lanif.auth.client.exception;

/**
 */
public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String s) {
        super(s);
    }
}
