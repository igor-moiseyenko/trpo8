package com.imoiseyenko.spastructure.common.exception;

/**
 * Spastructure exception creator interface.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public interface SpastructureExceptionCreator {

	/**
	 * Create {@link SpastructureException} exception.
	 * 
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	public SpastructureException createException ();

	/**
	 * Create {@link SpastructureException} exception with specified cause.
	 * 
	 * @param cause
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	public SpastructureException createException (Throwable cause);
}
