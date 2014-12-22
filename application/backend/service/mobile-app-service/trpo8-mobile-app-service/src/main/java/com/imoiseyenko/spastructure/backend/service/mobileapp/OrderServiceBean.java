package com.imoiseyenko.spastructure.backend.service.mobileapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.AccountDAO;
import com.imoiseyenko.spastructure.backend.repository.dao.OrderDAO;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.repository.entity.Order;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.service.mobileapp.converter.OrderVOConverter;
import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.MobileAppServiceException;
import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.creator.MobileAppServiceExceptionCreator;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.OrderVO;

/**
 * Order service implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
@Service
public class OrderServiceBean implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderVOConverter orderVOConverter;

	@Autowired
	private AccountDAO accountDAO;

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void createOrder (OrderVO orderVO, String email) throws MobileAppServiceException {

		try {

			Account account = accountDAO.findAccountByUsername(email);
			Order order = orderVOConverter.convertOrderVOToEntity(orderVO);
			order.setAccount(account);
			orderDAO.create(order);
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_CREATE_ORDER.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrderVO getOrder (Long id) throws MobileAppServiceException {

		try {

			return orderVOConverter.convertOrderToVO(orderDAO.findById(id));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_CREATE_ORDER.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrderVO> getOrdersByEmail (String email) throws MobileAppServiceException {

		try {

			return orderVOConverter.convertOrdersToVOs(orderDAO.findOrdersByEmail(email));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_GET_ORDERS_BY_ACCOUNT_ID.createException(ex);
		}
	}

}
