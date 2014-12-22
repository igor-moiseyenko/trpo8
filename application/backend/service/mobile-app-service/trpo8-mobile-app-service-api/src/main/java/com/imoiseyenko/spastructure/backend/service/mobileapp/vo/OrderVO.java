package com.imoiseyenko.spastructure.backend.service.mobileapp.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Order value object.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
public class OrderVO implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long accountId;
	private List<OrderItemVO> orderItemVOs;

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public Long getAccountId () {
		return accountId;
	}

	public void setAccountId (Long accountId) {
		this.accountId = accountId;
	}

	public List<OrderItemVO> getOrderItemVOs () {
		return orderItemVOs;
	}

	public void setOrderItemVOs (List<OrderItemVO> orderItemVOs) {
		this.orderItemVOs = orderItemVOs;
	}
}
