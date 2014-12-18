package com.imoiseyenko.spastructure.common.util;

import java.util.Date;

/**
 * Token information.
 *
 * @author igor.moiseyenko@nasty-creatures.com 
 * @version 0.1 Apr 20, 2014
 */
public class TokenInfo {

	private String username;
	private Date expirationTime;
	private Permissions permissions;

	public TokenInfo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
}
