package com.imoiseyenko.spastructure.backend.webservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.imoiseyenko.spastructure.backend.service.profile.ProfileService;
import com.imoiseyenko.spastructure.backend.service.profile.SessionService;
import com.imoiseyenko.spastructure.backend.service.profile.vo.ProfileVO;
import com.imoiseyenko.spastructure.backend.service.profile.vo.TokenInfoVO;
import com.imoiseyenko.spastructure.common.exception.SpastructureException;

@RestController
@RequestMapping(value = "/v1/profiles")
public class ProfileRestController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private SessionService sessionService;

	/**
	 * Get profile of current logged in user.
	 * 
	 * @param tokenData
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ProfileVO getProfile (@RequestHeader("token_data") String tokenData) throws SpastructureException {

		TokenInfoVO tokenInfoVO = sessionService.verifySession(tokenData);

		return profileService.getProfileByEmail(tokenInfoVO.getUsername());
	}
}
