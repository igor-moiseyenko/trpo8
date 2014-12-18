package com.imoiseyenko.spastructure.backend.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.AccountDAO;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.exception.creator.SpastructureProfileServiceExceptionCreator;

/**
 * Auth service implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 18, 2014
 */
@Service
public class AuthServiceBean implements AuthService {

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
	public void signOut (String accessToken, String email) throws SpastructureProfileServiceException {

		try {

			Account account = accountDAO.findAccountByUsername(email);

			if (account != null) {

				Session token = account.getSessionByAccessToken(accessToken);
				account.deleteSession(token);
				accountDAO.update(account);
			}

		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_SIGN_OUT.createException(ex);
		}
	}

}
