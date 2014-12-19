package com.imoiseyenko.spastructure.backend.webservice.mobileapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.imoiseyenko.spastructure.backend.service.mobileapp.MobileAppService;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.MobileAppVO;
import com.imoiseyenko.spastructure.backend.service.profile.SessionService;
import com.imoiseyenko.spastructure.common.exception.SpastructureException;

/**
 * Mobile applications REST API controller.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
@RestController
@RequestMapping("/v1/mobileapps")
public class MobileAppRestController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private MobileAppService mobileAppService;

	/**
	 * Get mobile application with specified id.
	 * 
	 * @param tokenData
	 * @param id
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public MobileAppVO getMobileAppById (@RequestHeader("access_token") String tokenData, @PathVariable("id") Long id)
			throws SpastructureException {

		sessionService.verifySession(tokenData);

		return mobileAppService.getMobileAppById(id);
	}

	/**
	 * Get all mobile applications.
	 * 
	 * @param tokenData
	 * @return
	 * @throws SpastructureException
	 * @author imoiseyenko93@gmail.com
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<MobileAppVO> getAllMobileApps (@RequestHeader("access_token") String tokenData)
			throws SpastructureException {

		sessionService.verifySession(tokenData);

		return mobileAppService.getAllMobileApps();
	}
}
