package com.imoiseyenko.spastructure.backend.service.profile;

import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;

/**
 * Auth service interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 18, 2014
 */
public interface AuthService {

	/**
	 * Sign out.
	 * 
	 * @param accessToken
	 * @param email
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void signOut (String accessToken, String email) throws SpastructureProfileServiceException;
}
