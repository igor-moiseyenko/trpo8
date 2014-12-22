package com.imoiseyenko.spastructure.backend.repository.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"ORDER\"")
@NamedQueries({
		@NamedQuery(name = "Order.findAllOrders", query = "select o from Order o"),
		@NamedQuery(name = "Order.findOrdersByEmail", query = "select o from Order o where o.account.username = :email") })
public class Order implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<OrderItem> orderItems;

	@ManyToOne
	private Account account;

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItems () {
		return orderItems;
	}

	public void setOrderItems (List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Account getAccount () {
		return account;
	}

	public void setAccount (Account account) {
		this.account = account;
	}
}
