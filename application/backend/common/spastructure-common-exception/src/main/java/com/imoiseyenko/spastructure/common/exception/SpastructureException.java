package com.imoiseyenko.spastructure.common.exception;

/**
 * Base Spastructure exception
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public class SpastructureException extends Exception {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	private SpastructureExceptionDefinition exceptionDefinition;

	public SpastructureException (SpastructureExceptionDefinition exceptionDefinition) {

		super(exceptionDefinition.getMessage());
		this.exceptionDefinition = exceptionDefinition;
	}

	public SpastructureException (SpastructureExceptionDefinition exceptionDefinition,
			Throwable cause) {

		super(exceptionDefinition.getMessage(), cause);
		this.exceptionDefinition = exceptionDefinition;
	}

	public SpastructureExceptionDefinition getExceptionDefinition () {
		return exceptionDefinition;
	}

	public void setExceptionDefinition (SpastructureExceptionDefinition exceptionDefinition) {
		this.exceptionDefinition = exceptionDefinition;
	}
}
