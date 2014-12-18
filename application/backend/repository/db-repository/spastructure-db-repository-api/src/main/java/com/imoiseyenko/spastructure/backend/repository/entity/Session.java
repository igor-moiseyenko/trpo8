package com.imoiseyenko.spastructure.backend.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SESSION")
@NamedQueries({ @NamedQuery(name = "Session.findSessionByAccessToken", query = "SELECT s FROM Session s WHERE s.accessToken = :accessToken") })
public class Session {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ACCESS_TOKEN")
	private String accessToken;

	@ManyToOne
	private Account account;

	public Session () {
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

	public Account getAccount () {
		return account;
	}

	public void setAccount (Account account) {
		this.account = account;
	}
}
