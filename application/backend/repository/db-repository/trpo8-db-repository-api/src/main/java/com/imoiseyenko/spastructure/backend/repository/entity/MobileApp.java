package com.imoiseyenko.spastructure.backend.repository.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Mobile application entity.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
@Entity
@Table(name = "MOBILE_APP")
@NamedQueries({ @NamedQuery(name = "MobileApp.findAllMobileApps", query = "select ma from MobileApp ma") })
public class MobileApp implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private MobileAppType mobileAppType;

	@Column(name = "RAITING")
	private Integer raiting;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	private Developer developer;

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Double getPrice () {
		return price;
	}

	public void setPrice (Double price) {
		this.price = price;
	}

	public MobileAppType getMobileAppType () {
		return mobileAppType;
	}

	public void setMobileAppType (MobileAppType mobileAppType) {
		this.mobileAppType = mobileAppType;
	}

	public Integer getRaiting () {
		return raiting;
	}

	public void setRaiting (Integer raiting) {
		this.raiting = raiting;
	}

	public String getDescription () {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}
}
