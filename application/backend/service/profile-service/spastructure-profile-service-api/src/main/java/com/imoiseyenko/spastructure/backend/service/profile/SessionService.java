package com.imoiseyenko.spastructure.backend.service.profile;

import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.backend.service.profile.vo.TokenInfoVO;

/**
 * Session service interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public interface SessionService {

	/**
	 * Verify session with specified access token.
	 * 
	 * @param accessToken
	 * @return
	 * @throws SpastructureProfileServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public TokenInfoVO verifySession (String accessToken) throws SpastructureProfileServiceException;
}
