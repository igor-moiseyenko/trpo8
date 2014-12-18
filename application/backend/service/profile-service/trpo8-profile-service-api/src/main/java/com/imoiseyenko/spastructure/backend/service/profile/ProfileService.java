package com.imoiseyenko.spastructure.backend.service.profile;

import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.vo.ProfileVO;
import com.imoiseyenko.spastructure.backend.service.profile.vo.SessionVO;

/**
 * Profile service interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 26, 2014
 */
public interface ProfileService {

	/**
	 * Create profile.
	 * 
	 * @param profileVO
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void createProfile (ProfileVO profileVO) throws SpastructureProfileServiceException;

	/**
	 * Get profile with specified id.
	 * 
	 * @param id
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public ProfileVO getProfileById (Long id) throws SpastructureProfileServiceException;

	/**
	 * Update profile.
	 * 
	 * @param email
	 * @param profileVO
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void updateProfile (String email, ProfileVO profileVO) throws SpastructureProfileServiceException;

	/**
	 * Delete profile.
	 * 
	 * @param profileVO
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void deleteProfile (ProfileVO profileVO) throws SpastructureProfileServiceException;

	/**
	 * Delete profile with specified id.
	 * 
	 * @param id
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void deleteProfileById (Long id) throws SpastructureProfileServiceException;

	/**
	 * Register new profile with specified data.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public SessionVO register (String email, String password) throws SpastructureProfileServiceException;

	/**
	 * Get profile with specified email.
	 * 
	 * @param email
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public ProfileVO getProfileByEmail (String email) throws SpastructureProfileServiceException;
}
