package com.imoiseyenko.spastructure.backend.repository.exception;

import com.imoiseyenko.spastructure.common.exception.SpastructureException;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionDefinition;

/**
 * Spastructure DB repository exception.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public class SpastructureDBRepositoryException extends SpastructureException {

	/** Serial version id */
	private static final long serialVersionUID = 1L;

	public SpastructureDBRepositoryException (SpastructureExceptionDefinition exceptionDefinition) {
		super(exceptionDefinition);
	}

	public SpastructureDBRepositoryException (SpastructureExceptionDefinition exceptionDefinition, Throwable cause) {
		super(exceptionDefinition, cause);
	}
}
