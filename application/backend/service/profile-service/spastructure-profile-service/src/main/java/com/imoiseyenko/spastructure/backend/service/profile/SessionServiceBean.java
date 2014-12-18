package com.imoiseyenko.spastructure.backend.service.profile;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.AccountDAO;
import com.imoiseyenko.spastructure.backend.repository.dao.SessionDAO;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.service.profile.converter.TokenInfoVOConverter;
import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.exception.creator.SpastructureProfileServiceExceptionCreator;
import com.imoiseyenko.spastructure.backend.service.profile.vo.TokenInfoVO;
import com.imoiseyenko.spastructure.common.util.TokenCreator;
import com.imoiseyenko.spastructure.common.util.TokenInfo;

/**
 * Session service implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
@Service
public class SessionServiceBean implements SessionService {

	@Autowired
	private SessionDAO sessionDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private TokenInfoVOConverter tokenInfoVOConverter;

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TokenInfoVO verifySession (String accessToken) throws SpastructureProfileServiceException {

		try {

			Session session = sessionDAO.findSessionByAccessToken(accessToken);

			// Check session exist.
			if (session != null) {

				// Check account to be logged in.
				if (session.getAccount() != null && session.getAccount().isLoggedIn()) {

					TokenInfo tokenInfo = TokenCreator.parseToken(session.getAccessToken());

					// Check token expiration time.
					if (tokenInfo.getExpirationTime().getTime() > System.currentTimeMillis()) {

						return tokenInfoVOConverter.convertTokenInfoToVO(tokenInfo);
					} else {
						throw SpastructureProfileServiceExceptionCreator.INVALID_TOKEN_EXPIRATION_TIME
								.createException();
					}
				} else {
					throw SpastructureProfileServiceExceptionCreator.YOU_HAVE_TO_LOGIN_FIRST.createException();
				}
			} else {
				throw SpastructureProfileServiceExceptionCreator.SESSION_DOES_NOT_EXIST.createException();
			}
		} catch (SpastructureDBRepositoryException | ParseException | RuntimeException ex) {
			throw SpastructureProfileServiceExceptionCreator.CANNOT_VERIFY_TOKEN.createException(ex);
		}
	}

}
