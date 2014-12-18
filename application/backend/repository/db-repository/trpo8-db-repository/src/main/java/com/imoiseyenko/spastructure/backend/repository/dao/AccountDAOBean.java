package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.repository.exception.creator.SpastructureDBRepositoryExceptionCreator;

/**
 * Account DAO implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
@Repository
@Transactional
public class AccountDAOBean extends GenericDAOBean<Account, Long> implements AccountDAO {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public Account findAccountByUsername (String username) throws SpastructureDBRepositoryException {

		try {

			TypedQuery<Account> query = entityManager.createNamedQuery("Account.findAccountByUsername", Account.class);
			query.setParameter("username", username);
			List<Account> accounts = query.getResultList();

			return !accounts.isEmpty() ? accounts.get(0) : null;
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_ACCOUNT_BY_USERNAME.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public List<Account> findAllAccounts () throws SpastructureDBRepositoryException {

		try {

			TypedQuery<Account> query = entityManager.createNamedQuery("Account.findAllAccounts", Account.class);

			return query.getResultList();
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_ALL_ACCOUNTS.createException(ex);
		}
	}

}
