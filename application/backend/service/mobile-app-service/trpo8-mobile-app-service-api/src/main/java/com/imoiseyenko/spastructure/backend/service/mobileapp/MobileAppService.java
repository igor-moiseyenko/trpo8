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
	 * Get mobile application with specified id.
	 * 
	 * @param id
	 * @return
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public MobileAppVO getMobileAppById (Long id) throws MobileAppServiceException;

	/**
	 * Get list of mobile applications.
	 * 
	 * @return
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public List<MobileAppVO> getAllMobileApps () throws MobileAppServiceException;

	/**
	 * Update mobile application.
	 * 
	 * @param mobileAppVO
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void updateMobileApp (MobileAppVO mobileAppVO) throws MobileAppServiceException;

	/**
	 * Delete mobile application with specified id.
	 * 
	 * @param id
	 * @throws MobileAppServiceException
	 * @author imoiseyenko93@gmail.com
	 */
	public void deleteMobileAppById (Long id) throws MobileAppServiceException;
}
