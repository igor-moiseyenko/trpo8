package com.imoiseyenko.spastructure.backend.service.mobileapp.vo;

import java.io.Serializable;

/**
 * Mobile application value object.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
public class MobileAppVO implements Serializable {

	/** Serial version id */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double price;
	private String type;
	private Integer raiting;
	private String description;

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

	public String getType () {
		return type;
	}

	public void setType (String type) {
		this.type = type;
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
