package com.imoiseyenko.spastructure.backend.webservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.imoiseyenko.spastructure.backend.service.profile.AccountService;
import com.imoiseyenko.spastructure.backend.service.profile.AuthService;
import com.imoiseyenko.spastructure.backend.service.profile.ProfileService;
import com.imoiseyenko.spastructure.backend.service.profile.SessionService;
import com.imoiseyenko.spastructure.backend.service.profile.vo.SessionVO;
import com.imoiseyenko.spastructure.backend.service.profile.vo.TokenInfoVO;
import com.imoiseyenko.spastructure.common.exception.SpastructureException;

/**
 * Auth REST API controller.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 18, 2014
 */
@RestController
@RequestMapping("/v1")
public class AuthRestController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private AuthService authService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private AccountService accountService;

	/**
	 * Sign up.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public SessionVO signUp (@RequestParam("email") String email, @RequestParam("password") String password)
			throws SpastructureException {

		return profileService.register(email, password);
	}

	/**
	 * Sign in.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public SessionVO signIn (@RequestParam("email") String email, @RequestParam("password") String password)
			throws SpastructureException {

		return accountService.login(email, password);
	}

	/**
	 * Sign out.
	 * 
	 * @param accessToken
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/signout")
	public void signOut (@RequestHeader("access_token") String accessToken) throws SpastructureException {

		TokenInfoVO tokenInfoVO = sessionService.verifySession(accessToken);
		authService.signOut(accessToken, tokenInfoVO.getUsername());
	}
}
