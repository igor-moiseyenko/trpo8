package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import com.imoiseyenko.spastructure.backend.repository.entity.Order;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;

/**
 * Order data access object interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
public interface OrderDAO extends GenericDAO<Order, Long> {

	/**
	 * Find and return all orders.
	 * 
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<Order> findAllOrders () throws SpastructureDBRepositoryException;

	/**
	 * Find and return orders of user with specified email.
	 * 
	 * @param email
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<Order> findOrdersByEmail (String email) throws SpastructureDBRepositoryException;
}
