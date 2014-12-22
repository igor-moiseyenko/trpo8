package com.imoiseyenko.spastructure.backend.service.mobileapp.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.repository.entity.Order;
import com.imoiseyenko.spastructure.backend.repository.entity.OrderItem;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.OrderItemVO;

/**
 * Order item value object converter.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
@Component
public class OrderItemVOConverter {

	@Autowired
	private MobileAppVOConverter mobileAppVOConverter;

	public OrderItemVO convertOrderItemToVO (OrderItem orderItem) {

		OrderItemVO orderItemVO = null;

		if (orderItem != null) {

			orderItemVO = new OrderItemVO();
			orderItemVO.setId(orderItem.getId());
			orderItemVO.setMobileAppVO(mobileAppVOConverter.convertMobileAppToVO(orderItem.getMobileApp()));
			orderItemVO.setQuantity(orderItem.getQuantity());
		}

		return orderItemVO;
	}

	public List<OrderItemVO> convertOrderItemsToVOs (List<OrderItem> orderItems) {

		List<OrderItemVO> orderItemVOs = new ArrayList<>();

		if (orderItems != null && !orderItems.isEmpty()) {
			for (OrderItem orderItem : orderItems) {
				orderItemVOs.add(convertOrderItemToVO(orderItem));
			}
		}

		return orderItemVOs;
	}

	public OrderItem convertOrderItemVOToEntity (OrderItemVO orderItemVO, Order order) {

		OrderItem orderItem = null;

		if (orderItemVO != null) {

			orderItem = new OrderItem();
			orderItem.setId(orderItemVO.getId());
			orderItem.setMobileApp(mobileAppVOConverter.convertMobileAppVOToEntity(orderItemVO.getMobileAppVO()));
			orderItem.setQuantity(orderItemVO.getQuantity());
			orderItem.setOrder(order);
		}

		return orderItem;
	}

	public List<OrderItem> convertOrderItemVOsToEntities (List<OrderItemVO> orderItemVOs, Order order) {

		List<OrderItem> orderItems = new ArrayList<>();

		if (orderItemVOs != null && !orderItemVOs.isEmpty()) {
			for (OrderItemVO orderItemVO : orderItemVOs) {
				orderItems.add(convertOrderItemVOToEntity(orderItemVO, order));
			}
		}

		return orderItems;
	}
}
