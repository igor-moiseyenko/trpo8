package com.imoiseyenko.spastructure.backend.service.mobileapp.exception;

import com.imoiseyenko.spastructure.common.exception.SpastructureException;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionDefinition;

/**
 * Mobile application service exception.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Dec 19, 2014
 */
public class MobileAppServiceException extends SpastructureException {

	/** Serial version id */
	private static final long serialVersionUID = 1L;

	public MobileAppServiceException (SpastructureExceptionDefinition exceptionDefinition) {
		super(exceptionDefinition);
	}

	public MobileAppServiceException (SpastructureExceptionDefinition exceptionDefinition, Throwable cause) {
		super(exceptionDefinition);
	}
}
