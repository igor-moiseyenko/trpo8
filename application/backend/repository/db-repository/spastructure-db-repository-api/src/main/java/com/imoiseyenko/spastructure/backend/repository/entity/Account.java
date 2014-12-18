package com.imoiseyenko.spastructure.backend.repository.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * SPA structure account.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
		@NamedQuery(name = "Account.findAccountByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
		@NamedQuery(name = "Account.findAllAccounts", query = "SELECT a FROM Account a") })
public class Account {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "LOGGED_IN")
	private boolean loggedIn;

	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Session> sessions;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Profile profile;

	public Account () {
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

	public boolean isLoggedIn () {
		return loggedIn;
	}

	public void setLoggedIn (boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public List<Session> getSessions () {
		return sessions;
	}

	public void setSessions (List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session getSessionByAccessToken (String accessToken) {

		Session foundSession = null;

		if (sessions != null & !sessions.isEmpty()) {
			for (Session session : sessions) {
				if (session.getAccessToken().equals(accessToken)) {
					foundSession = session;
					break;
				}
			}
		}

		return foundSession;
	}

	public void addSession (Session session) {

		if (sessions == null) {
			sessions = new ArrayList<>();
		}
		session.setAccount(this);
		sessions.add(session);
	}

	public void deleteSession (Session session) {

		if (sessions != null) {
			sessions.remove(session);
		}
	}

	public Profile getProfile () {
		return profile;
	}

	public void setProfile (Profile profile) {
		this.profile = profile;
	}
}
