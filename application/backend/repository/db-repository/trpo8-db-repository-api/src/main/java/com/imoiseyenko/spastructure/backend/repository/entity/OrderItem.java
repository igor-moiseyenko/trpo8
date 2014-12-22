package com.imoiseyenko.spastructure.backend.repository.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private MobileApp mobileApp;

	@ManyToOne
	private Order order;

	@Column(name = "QUANTITY")
	private Integer quantity;

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public MobileApp getMobileApp () {
		return mobileApp;
	}

	public void setMobileApp (MobileApp mobileApp) {
		this.mobileApp = mobileApp;
	}

	public Order getOrder () {
		return order;
	}

	public void setOrder (Order order) {
		this.order = order;
	}

	public Integer getQuantity () {
		return quantity;
	}

	public void setQuantity (Integer quantity) {
		this.quantity = quantity;
	}
}
