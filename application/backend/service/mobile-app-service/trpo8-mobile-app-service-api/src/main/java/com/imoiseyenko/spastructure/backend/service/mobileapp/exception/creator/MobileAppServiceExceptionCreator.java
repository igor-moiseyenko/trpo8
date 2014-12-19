package com.imoiseyenko.spastructure.backend.service.mobileapp.exception.creator;

import com.imoiseyenko.spastructure.backend.service.mobileapp.exception.MobileAppServiceException;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionCreator;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionDefinition;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionType;

/**
 * Mobile application service exceptions creator.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
public enum MobileAppServiceExceptionCreator implements SpastructureExceptionCreator {

	/** 3000-3999 codes for mobile app service exceptions. */

	CANNOT_GET_ALL_MOBILE_APPS("TRPO8-3000", "Cannot get all mobile apps."),
	;

	private SpastructureExceptionDefinition exceptionDefinition;

	private MobileAppServiceExceptionCreator (String code, String message) {

		this.exceptionDefinition = new SpastructureExceptionDefinition(code, message, SpastructureExceptionType.SERVICE);
	}

	public SpastructureExceptionDefinition getExceptionDefinition () {
		return exceptionDefinition;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public MobileAppServiceException createException () {

		return new MobileAppServiceException(exceptionDefinition);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public MobileAppServiceException createException (Throwable cause) {

		return new MobileAppServiceException(exceptionDefinition, cause);
	}

}
