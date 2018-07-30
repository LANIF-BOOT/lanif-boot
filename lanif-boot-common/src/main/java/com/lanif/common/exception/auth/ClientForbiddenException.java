package com.lanif.common.exception.auth;


import com.lanif.common.constant.CommonConstants;
import com.lanif.common.exception.BaseException;

/**
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
