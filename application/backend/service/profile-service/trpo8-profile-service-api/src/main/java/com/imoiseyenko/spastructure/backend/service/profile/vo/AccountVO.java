package com.imoiseyenko.spastructure.backend.service.profile.vo;

import java.io.Serializable;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;

/**
 * Value object for the {@link Account} entity instance.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
public class AccountVO implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String password;

	public AccountVO () {
	}

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getUsername () {
		return username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}
}
