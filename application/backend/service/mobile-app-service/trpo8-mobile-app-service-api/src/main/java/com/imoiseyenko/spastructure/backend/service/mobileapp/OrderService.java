package com.imoiseyenko.spastructure.backend.service.mobileapp;

import java.util.List;
import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.MobileAppServiceException;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.OrderVO;

/**
 * Order service interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
public interface OrderService {

	/**
	 * Create order.
	 * 
	 * @param orderVO
	 * @param email
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void createOrder (OrderVO orderVO, String email) throws MobileAppServiceException;

	/**
	 * Get order.
	 * 
	 * @param id
	 * @return
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public OrderVO getOrder (Long id) throws MobileAppServiceException;

	/**
	 * Get orders of user with specified email.
	 * 
	 * @param accountId
	 * @return
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<OrderVO> getOrdersByEmail (String email) throws MobileAppServiceException;
}
