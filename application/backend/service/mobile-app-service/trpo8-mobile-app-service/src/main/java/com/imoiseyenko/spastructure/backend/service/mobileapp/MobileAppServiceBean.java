package com.imoiseyenko.spastructure.backend.service.mobileapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imoiseyenko.spastructure.backend.repository.dao.MobileAppDAO;
import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.backend.service.mobileapp.converter.MobileAppVOConverter;
import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.MobileAppServiceException;
import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.creator.MobileAppServiceExceptionCreator;
import com.imoiseyenko.spastructure.backend.service.mobileapp.vo.MobileAppVO;

/**
 * Mobile applications service implementation.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
@Service
public class MobileAppServiceBean implements MobileAppService {

	@Autowired
	private MobileAppDAO mobileAppDAO;

	@Autowired
	private MobileAppVOConverter mobileAppVOConverter;

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MobileAppVO getMobileAppById (Long id) throws MobileAppServiceException {

		try {

			return mobileAppVOConverter.convertMobileAppToVO(mobileAppDAO.findById(id));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_GET_MOBILE_APP_BY_ID.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MobileAppVO> getAllMobileApps () throws MobileAppServiceException {

		try {

			return mobileAppVOConverter.convertMobileAppsToVOs(mobileAppDAO.findAllMobileApps());
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_GET_ALL_MOBILE_APPS.createException(ex);
		}
	}

}
