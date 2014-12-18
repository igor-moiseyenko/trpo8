package com.imoiseyenko.spastructure.backend.service.profile.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Value object for session.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public class TokenInfoVO implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private String username;
	private Date expirationTime;

	public TokenInfoVO () {
	}

	public String getUsername () {
		return username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public Date getExpirationTime () {
		return expirationTime;
	}

	public void setExpirationTime (Date expirationTime) {
		this.expirationTime = expirationTime;
	}
}
