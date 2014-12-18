package com.imoiseyenko.spastructure.backend.service.profile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.AccountDAO;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.service.profile.converter.AccountVOConverter;
import com.imoiseyenko.spastructure.backend.service.profile.converter.TokenInfoVOConverter;
import com.imoiseyenko.spastructure.backend.service.profile.converter.SessionVOConverter;
import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.exception.creator.SpastructureProfileServiceExceptionCreator;
import com.imoiseyenko.spastructure.backend.service.profile.vo.AccountVO;
import com.imoiseyenko.spastructure.backend.service.profile.vo.SessionVO;
import com.imoiseyenko.spastructure.common.util.Permissions;
import com.imoiseyenko.spastructure.common.util.TokenCreator;

/**
 * Account service implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Mar 31, 2014
 */
@Service
public class AccountServiceBean implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private AccountVOConverter accountVOConverter;

	@Autowired
	private SessionVOConverter tokenVOConverter;

	@Autowired
	private TokenInfoVOConverter tokenInfoVOConverter;

	private long expirationTimeDelta;

	public void setExpirationTimeDelta (long expirationTimeDelta) {
		this.expirationTimeDelta = expirationTimeDelta;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void createAccount (AccountVO accountVO) throws SpastructureProfileServiceException {

		try {

			accountDAO.create(accountVOConverter.convertAccountVOToEntity(accountVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_CREATE_ACCOUNT.createException(ex);
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
	public AccountVO getAccountById (Long id) throws SpastructureProfileServiceException {

		try {

			return accountVOConverter.convertAccountToVO(accountDAO.findById(id));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_GET_ACCOUNT.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAccount (AccountVO accountVO) throws SpastructureProfileServiceException {

		try {

			accountDAO.update(accountVOConverter.convertAccountVOToEntity(accountVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_UPDATE_ACCOUNT.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAccount (AccountVO accountVO) throws SpastructureProfileServiceException {

		try {

			accountDAO.delete(accountVOConverter.convertAccountVOToEntity(accountVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_DELETE_ACCOUNT.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAccountById (Long id) throws SpastructureProfileServiceException {

		try {

			accountDAO.deleteById(id);
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_DELETE_ACCOUNT.createException(ex);
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
	public AccountVO getAccountByUsername (String username) throws SpastructureProfileServiceException {

		try {

			return accountVOConverter.convertAccountToVO(accountDAO.findAccountByUsername(username));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_GET_ACCOUNT_BY_USERNAME.createException(ex);
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
	public List<AccountVO> getAllAccounts () throws SpastructureProfileServiceException {

		try {

			List<Account> accounts = accountDAO.findAllAccounts();

			return accountVOConverter.convertAccountsToVO(accounts);
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_GET_ALL_ACCOUNTS.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SessionVO login (String email, String password) throws SpastructureProfileServiceException {

		SessionVO tokenVO = null;

		try {

			Account account = accountDAO.findAccountByUsername(email);

			// Check for the existence of account with specified email && password to be correct.
			if (account != null && account.getPassword().equals(password)) {

				// Generate token data.
				String tokenData = TokenCreator.createToken(email, expirationTimeDelta, Permissions.U);
				Session token = new Session();
				token.setAccessToken(tokenData);

				// Update account.
				account.setLoggedIn(true);
				account.addSession(token);
				accountDAO.update(account);

				// Initialize token value object.
				tokenVO = tokenVOConverter.convertSessionToVO(token);
			} else {
				throw SpastructureProfileServiceExceptionCreator.INVALID_USERNAME_OR_PASSWORD.createException();
			}
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_LOGIN.createException(ex);
		}

		return tokenVO;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void logout (String email) throws SpastructureProfileServiceException {
		// TODO Auto-generated method stub

	}

}
