package com.imoiseyenko.spastructure.backend.service.profile.exception;

import com.imoiseyenko.spastructure.common.exception.SpastructureException;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionDefinition;

/**
 * Spastructure profile service exception.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public class SpastructureProfileServiceException extends SpastructureException {

	/** Serial version id */
	private static final long serialVersionUID = 1L;

	public SpastructureProfileServiceException (SpastructureExceptionDefinition exceptionDefinition) {
		super(exceptionDefinition);
	}

	public SpastructureProfileServiceException (SpastructureExceptionDefinition exceptionDefinition, Throwable cause) {
		super(exceptionDefinition, cause);
	}
}
