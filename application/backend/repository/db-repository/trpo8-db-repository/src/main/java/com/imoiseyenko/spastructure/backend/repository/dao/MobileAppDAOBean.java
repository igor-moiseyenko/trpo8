package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.imoiseyenko.spastructure.backend.repository.entity.MobileApp;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.repository.exception.creator.SpastructureDBRepositoryExceptionCreator;

/**
 * Mobile application data access object implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
@Repository
@Transactional
public class MobileAppDAOBean extends GenericDAOBean<MobileApp, Long> implements MobileAppDAO {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public List<MobileApp> findAllMobileApps () throws SpastructureDBRepositoryException {

		try {

			TypedQuery<MobileApp> query = entityManager
					.createNamedQuery("MobileApp.findAllMobileApps", MobileApp.class);

			return query.getResultList();
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_ALL_MOBILE_APPS.createException(ex);
		}
	}

}
