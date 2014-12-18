package com.imoiseyenko.spastructure.backend.service.profile;

import java.util.List;
import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.vo.AccountVO;
import com.imoiseyenko.spastructure.backend.service.profile.vo.SessionVO;

/**
 * Account service interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
public interface AccountService {

	/**
	 * Create new account.
	 * 
	 * @param accountVO
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void createAccount (AccountVO accountVO) throws SpastructureProfileServiceException;

	/**
	 * Get account by id.
	 * 
	 * @param id
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public AccountVO getAccountById (Long id) throws SpastructureProfileServiceException;

	/**
	 * Update account.
	 * 
	 * @param accountVO
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void updateAccount (AccountVO accountVO) throws SpastructureProfileServiceException;

	/**
	 * Delete account.
	 * 
	 * @param accountVO
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void deleteAccount (AccountVO accountVO) throws SpastructureProfileServiceException;

	/**
	 * Delete account by id.
	 * 
	 * @param id
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void deleteAccountById (Long id) throws SpastructureProfileServiceException;

	/**
	 * Get account by user name.
	 * 
	 * @param username
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public AccountVO getAccountByUsername (String username) throws SpastructureProfileServiceException;

	/**
	 * Get all accounts.
	 * 
	 * @return list of {@link AccountVO} instances.
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<AccountVO> getAllAccounts () throws SpastructureProfileServiceException;

	/**
	 * Login with specified credentials.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public SessionVO login (String email, String password) throws SpastructureProfileServiceException;

	/**
	 * Logout.
	 * 
	 * @param email
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void logout (String email) throws SpastructureProfileServiceException;
}
