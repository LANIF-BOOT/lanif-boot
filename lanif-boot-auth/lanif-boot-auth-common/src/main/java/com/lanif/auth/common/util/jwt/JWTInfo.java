/**
 * 
 */
package com.lanif.auth.common.util.jwt;

import java.io.Serializable;

/**
 * @Title: JWTInfo.java
 * @Package com.lanif.auth.common.util.jwt
 * @Description: TODO(用一句话描述该类功能)
 * @author weiq
 * @date 2018年7月30日 上午10:48:26
 * @version V1.0 update_data: update_author: update_note:
 */

public class JWTInfo implements Serializable, IJWTInfo {
	private String username;
	private String userId;
	private String name;

	public JWTInfo(String username, String userId, String name) {
		this.username = username;
		this.userId = userId;
		this.name = name;
	}

	@Override
	public String getUniqueName() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		JWTInfo jwtInfo = (JWTInfo) o;

		if (username != null ? !username.equals(jwtInfo.username) : jwtInfo.username != null) {
			return false;
		}
		return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		return result;
	}
}
