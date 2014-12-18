package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;

/**
 * Account DAO interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
public interface AccountDAO extends GenericDAO<Account, Long> {

	/**
	 * Find instance of {@link Account} by user name.
	 * 
	 * @param username
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public Account findAccountByUsername (String username) throws SpastructureDBRepositoryException;

	/**
	 * Find all records of {@link Account} type.
	 * 
	 * @return list of found {@link Account} records or empty list otherwise.
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<Account> findAllAccounts () throws SpastructureDBRepositoryException;
}
