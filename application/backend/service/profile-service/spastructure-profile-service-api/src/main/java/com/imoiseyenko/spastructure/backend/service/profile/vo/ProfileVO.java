package com.imoiseyenko.spastructure.backend.service.profile.vo;

import java.io.Serializable;
import com.imoiseyenko.spastructure.backend.repository.entity.Profile;

/**
 * Value object for the {@link Profile} entity instance.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 26, 2014
 */
public class ProfileVO implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;

	public ProfileVO () {
	}

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getEmail () {
		return email;
	}

	public void setEmail (String email) {
		this.email = email;
	}
}
