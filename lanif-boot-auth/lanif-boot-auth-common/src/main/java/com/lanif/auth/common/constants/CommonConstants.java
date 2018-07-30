/**
 * 
 */
package com.lanif.auth.common.constants;

/**   
* @Title: CommonConstants.java
* @Package com.lanif.auth.common 
* @Description: TODO(用一句话描述该类功能) 
* @author weiq
* @date 2018年7月30日 上午10:42:51 
* @version V1.0   
*/

public class CommonConstants {
	public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";
    public static final Integer EX_TOKEN_ERROR_CODE = 40101;
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40102;
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40131;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
}
