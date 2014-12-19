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
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void createMobileApp (MobileAppVO mobileAppVO) throws MobileAppServiceException {

		try {

			mobileAppDAO.create(mobileAppVOConverter.convertMobileAppVOToEntity(mobileAppVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_CREATE_MOBILE_APP.createException(ex);
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

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMobileApp (MobileAppVO mobileAppVO) throws MobileAppServiceException {

		try {

			mobileAppDAO.update(mobileAppVOConverter.convertMobileAppVOToEntity(mobileAppVO));
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_UPDATE_MOBILE_APP.createException(ex);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMobileAppById (Long id) throws MobileAppServiceException {

		try {

			mobileAppDAO.deleteById(id);
		} catch (SpastructureDBRepositoryException | RuntimeException ex) {
			throw MobileAppServiceExceptionCreator.CANNOT_DELETE_MOBILE_APP.createException(ex);
		}
	}

}
