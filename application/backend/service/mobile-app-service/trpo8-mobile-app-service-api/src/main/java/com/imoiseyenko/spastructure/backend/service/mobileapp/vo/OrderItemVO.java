package com.imoiseyenko.spastructure.backend.service.mobileapp.vo;

import java.io.Serializable;

/**
 * Order item value object.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
public class OrderItemVO implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private Long id;
	private MobileAppVO mobileAppVO;
	private Integer quantity;

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public MobileAppVO getMobileAppVO () {
		return mobileAppVO;
	}

	public void setMobileAppVO (MobileAppVO mobileAppVO) {
		this.mobileAppVO = mobileAppVO;
	}

	public Integer getQuantity () {
		return quantity;
	}

	public void setQuantity (Integer quantity) {
		this.quantity = quantity;
	}
}
