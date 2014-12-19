package com.imoiseyenko.spastructure.backend.service.mobileapp;

import java.util.List;
import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.MobileAppServiceException;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.MobileAppVO;

/**
 * Mobile application service interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
public interface MobileAppService {

	/**
	 * Get list of mobile applications.
	 * 
	 * @return
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<MobileAppVO> getAllMobileApps () throws MobileAppServiceException;
}
