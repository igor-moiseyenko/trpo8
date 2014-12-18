package com.imoiseyenko.spastructure.backend.repository.dao;

import com.imoiseyenko.spastructure.backend.repository.entity.Session;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;

/**
 * Session DAO interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public interface SessionDAO extends GenericDAO<Session, Long> {

	/**
	 * Find session by specified access token.
	 * 
	 * @param accessToken
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public Session findSessionByAccessToken (String accessToken) throws SpastructureDBRepositoryException;
}
