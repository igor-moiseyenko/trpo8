package com.imoiseyenko.spastructure.backend.service.profile.vo;

import java.io.Serializable;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;

/**
 * Value object for the {@link Session} entity instance.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public class SessionVO implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String accessToken;
	private Long accountId;

	public SessionVO () {
	}

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getAccessToken () {
		return accessToken;
	}

	public void setAccessToken (String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getAccountId () {
		return accountId;
	}

	public void setAccountId (Long accountId) {
		this.accountId = accountId;
	}
}
