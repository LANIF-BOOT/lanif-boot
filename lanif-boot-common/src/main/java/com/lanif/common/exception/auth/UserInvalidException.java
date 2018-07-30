package com.lanif.common.exception.auth;


import com.lanif.common.constant.CommonConstants;
import com.lanif.common.exception.BaseException;

/**
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_PASS_INVALID_CODE);
    }
}
