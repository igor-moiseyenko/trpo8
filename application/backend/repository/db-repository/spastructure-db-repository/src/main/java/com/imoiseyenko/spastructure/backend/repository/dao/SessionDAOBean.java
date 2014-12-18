package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.repository.exception.creator.SpastructureDBRepositoryExceptionCreator;

/**
 * Session DAO implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
@Repository
@Transactional
public class SessionDAOBean extends GenericDAOBean<Session, Long> implements SessionDAO {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public Session findSessionByAccessToken (String accessToken) throws SpastructureDBRepositoryException {

		try {

			TypedQuery<Session> query = entityManager.createNamedQuery("Session.findSessionByAccessToken",
					Session.class);
			query.setParameter("accessToken", accessToken);
			List<Session> sessions = query.getResultList();

			return !sessions.isEmpty() ? sessions.get(0) : null;
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_SESSION_BY_ACCESS_TOKEN.createException(ex);
		}
	}
}
