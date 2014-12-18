package com.imoiseyenko.spastructure.backend.repository.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.entity.Profile;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.repository.exception.creator.SpastructureDBRepositoryExceptionCreator;

/**
 * Profile DAO implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 26, 2014
 */
@Repository
@Transactional
public class ProfileDAOBean extends GenericDAOBean<Profile, Long> implements ProfileDAO {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public Profile findProfileByEmail (String email) throws SpastructureDBRepositoryException {

		try {

			TypedQuery<Profile> query = entityManager.createNamedQuery("Profile.findProfileByEmail", Profile.class);
			query.setParameter("email", email);
			List<Profile> profiles = query.getResultList();

			return !profiles.isEmpty() ? profiles.get(0) : null;
		} catch (Exception ex) {
			throw SpastructureDBRepositoryExceptionCreator.CANNOT_FIND_PROFILE_BY_EMAIL.createException(ex);
		}
	}

}
