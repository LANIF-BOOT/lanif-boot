package com.lanif.common.msg.auth;

import com.lanif.common.constant.RestCodeConstants;
import com.lanif.common.msg.BaseResponse;

/**
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
