package com.imoiseyenko.spastructure.backend.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILE")
@NamedQueries({ @NamedQuery(name = "Profile.findProfileByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email") })
public class Profile {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstname;

	@Column(name = "LAST_NAME")
	private String lastname;

	@Column(name = "ADDRESS")
	private String address;

	public Profile () {
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

	public String getFirstname () {
		return firstname;
	}

	public void setFirstname (String firstname) {
		this.firstname = firstname;
	}

	public String getLastname () {
		return lastname;
	}

	public void setLastname (String lastname) {
		this.lastname = lastname;
	}

	public String getAddress () {
		return address;
	}

	public void setAddress (String address) {
		this.address = address;
	}
}
