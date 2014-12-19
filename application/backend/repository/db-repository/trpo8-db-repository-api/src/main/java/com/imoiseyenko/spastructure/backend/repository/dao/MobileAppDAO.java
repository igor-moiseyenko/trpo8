package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import com.imoiseyenko.spastructure.backend.repository.entity.MobileApp;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;

/**
 * Mobile application data access object interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
public interface MobileAppDAO extends GenericDAO<MobileApp, Long> {

	/**
	 * Find all mobile applications.
	 * 
	 * @return
	 * @throws SpastructureDBRepositoryException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<MobileApp> findAllMobileApps () throws SpastructureDBRepositoryException;
}
