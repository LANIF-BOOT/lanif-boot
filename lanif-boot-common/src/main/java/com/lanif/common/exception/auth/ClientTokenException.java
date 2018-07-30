package com.lanif.common.exception.auth;


import com.lanif.common.constant.CommonConstants;
import com.lanif.common.exception.BaseException;

/**
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
