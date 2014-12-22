package com.imoiseyenko.spastructure.backend.service.mobileapp.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.repository.entity.Order;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.OrderVO;

/**
 * Order value object converter.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
@Component
public class OrderVOConverter {

	@Autowired
	private OrderItemVOConverter orderItemVOConverter;

	public OrderVO convertOrderToVO (Order order) {

		OrderVO orderVO = null;

		if (order != null) {

			orderVO = new OrderVO();
			orderVO.setId(order.getId());
			orderVO.setAccountId(order.getAccount().getId());
			orderVO.setOrderItemVOs(orderItemVOConverter.convertOrderItemsToVOs(order.getOrderItems()));
		}

		return orderVO;
	}

	public List<OrderVO> convertOrdersToVOs (List<Order> orders) {

		List<OrderVO> orderVOs = new ArrayList<>();

		if (orders != null) {
			for (Order order : orders) {
				orderVOs.add(convertOrderToVO(order));
			}
		}

		return orderVOs;
	}

	public Order convertOrderVOToEntity (OrderVO orderVO) {

		Order order = null;

		if (orderVO != null) {

			order = new Order();
			order.setId(orderVO.getId());
			order.setOrderItems(orderItemVOConverter.convertOrderItemVOsToEntities(orderVO.getOrderItemVOs(), order));
		}

		return order;
	}
}
