package com.imoiseyenko.spastructure.backend.repository.dao;

import com.imoiseyenko.spastructure.backend.repository.entity.Profile;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;

/**
 * Profile DAO interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 26, 2014
 */
public interface ProfileDAO extends GenericDAO<Profile, Long> {

	/**
	 * Find profile with specified email.
	 * 
	 * @param email
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public Profile findProfileByEmail (String email) throws SpastructureDBRepositoryException;
}
