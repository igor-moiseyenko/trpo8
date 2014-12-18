package com.imoiseyenko.spastructure.backend.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.AccountDAO;
import com.imoiseyenko.spastructure.backend.repository.dao.ProfileDAO;
import com.imoiseyenko.spastructure.backend.repository.entity.Account;
import com.imoiseyenko.spastructure.backend.repository.entity.Profile;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.service.profile.converter.ProfileVOConverter;
import com.imoiseyenko.spastructure.backend.service.profile.converter.SessionVOConverter;
import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.exception.creator.SpastructureProfileServiceExceptionCreator;
import com.imoiseyenko.spastructure.backend.service.profile.vo.ProfileVO;
import com.imoiseyenko.spastructure.backend.service.profile.vo.SessionVO;
import com.imoiseyenko.spastructure.common.util.Permissions;
import com.imoiseyenko.spastructure.common.util.TokenCreator;

/**
 * Profile service implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 26, 2014
 */
@Service
public class ProfileServiceBean implements ProfileService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private ProfileDAO profileDAO;

	@Autowired
	private ProfileVOConverter profileVOConverter;

	@Autowired
	private SessionVOConverter tokenVOConverter;

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
	public void createProfile (ProfileVO profileVO) throws SpastructureProfileServiceException {

		try {

			profileDAO.create(profileVOConverter.convertProfileVOToEntity(profileVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_CREATE_PROFILE.createException(ex);
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
	public ProfileVO getProfileById (Long id) throws SpastructureProfileServiceException {

		try {

			return profileVOConverter.convertProfileToVO(profileDAO.findById(id));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_GET_PROFILE.createException(ex);
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
	public void updateProfile (ProfileVO profileVO) throws SpastructureProfileServiceException {

		try {

			profileDAO.update(profileVOConverter.convertProfileVOToEntity(profileVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_UPDATE_PROFILE.createException(ex);
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
	public void deleteProfile (ProfileVO profileVO) throws SpastructureProfileServiceException {

		try {

			profileDAO.delete(profileVOConverter.convertProfileVOToEntity(profileVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_DELETE_PROFILE.createException(ex);
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
	public void deleteProfileById (Long id) throws SpastructureProfileServiceException {

		try {

			profileDAO.deleteById(id);
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_DELETE_PROFILE.createException(ex);
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
	public SessionVO register (String email, String password) throws SpastructureProfileServiceException {

		SessionVO sessionVO = null;

		try {

			Account existingAccount = accountDAO.findAccountByUsername(email);

			// Check user name (email) to be unique.
			if (existingAccount == null) {

				// Generate token data.
				String accessToken = TokenCreator.createToken(email, expirationTimeDelta, Permissions.U);

				// Create token.
				Session session = new Session();
				session.setAccessToken(accessToken);

				// Create profile.
				Profile profile = new Profile();
				profile.setEmail(email);

				// Create account.
				Account account = new Account();
				account.setUsername(email);
				account.setPassword(password);
				account.setLoggedIn(true);
				account.addSession(session);
				account.setProfile(profile);

				// Save new account.
				accountDAO.create(account);

				// Initialize token value object.
				sessionVO = tokenVOConverter.convertSessionToVO(session);
			} else {
				throw SpastructureProfileServiceExceptionCreator.USERNAME_ALREADY_EXIST.createException();
			}
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_REGISTER.createException(ex);
		}

		return sessionVO;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public ProfileVO getProfileByEmail (String email) throws SpastructureProfileServiceException {

		try {

			return profileVOConverter.convertProfileToVO(profileDAO.findProfileByEmail(email));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_GET_PROFILE_BY_EMAIL.createException(ex);
		}
	}
}
