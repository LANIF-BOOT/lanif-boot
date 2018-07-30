/**
 * 
 */
package com.lanif.auth.common.util.jwt;

/**   
* @Title: IJWTInfo.java
* @Package com.lanif.auth.common.util.jwt 
* @Description: TODO(用一句话描述该类功能) 
* @author weiq
* @date 2018年7月30日 上午10:45:25 
* @version V1.0   
update_data: update_author: update_note:
*/

public interface IJWTInfo {
    /**
     * 获取用户名
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户ID
     * @return
     */
    String getId();

    /**
     * 获取名称
     * @return
     */
    String getName();
}

