package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.entity.Order;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.repository.exception.creator.SpastructureDBRepositoryExceptionCreator;

/**
 * Order data access object implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 21, 2014
 */
@Repository
@Transactional
public class OrderDAOBean extends GenericDAOBean<Order, Long> implements OrderDAO {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public List<Order> findAllOrders () throws SpastructureDBRepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public List<Order> findOrdersByEmail (String email) throws SpastructureDBRepositoryException {

		try {

			TypedQuery<Order> query = entityManager.createNamedQuery("Order.findOrdersByEmail", Order.class);
			query.setParameter("email", email);

			return query.getResultList();
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_ORDERS_BY_ACCOUNT_ID.createException(ex);
		}
	}

}
