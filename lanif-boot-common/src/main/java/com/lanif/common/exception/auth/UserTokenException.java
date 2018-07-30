package com.lanif.common.exception.auth;


import com.lanif.common.constant.CommonConstants;
import com.lanif.common.exception.BaseException;

/**
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
