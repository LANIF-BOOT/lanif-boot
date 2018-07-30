package com.lanif.common.msg.auth;

import com.lanif.common.constant.RestCodeConstants;
import com.lanif.common.msg.BaseResponse;

/**
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
