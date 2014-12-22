package com.imoiseyenko.spastructure.backend.repository.exception.creator;

import com.imoiseyenko.spastructure.backend.repository.exception.SpastructureDBRepositoryException;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionCreator;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionDefinition;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionType;

public enum SpastructureDBRepositoryExceptionCreator implements SpastructureExceptionCreator {

	/** 900-999 codes for Generic DAO layer exceptions. */
	CANNOT_CREATE_ENTITY("VIAE-900", "Cannot create entity."),
	CANNOT_FIND_ENTITY("VIAE-901", "Cannot find entity."),
	CANNOT_UPDATE_ENTITY("VIAE-902", "Cannot update entity."),
	CANNOT_DELETE_ENTITY("VIAE-903", "Cannot delete entity."),
	
	/** 1000-1999 codes for DB Repository layer exceptions. */
	
	/** 1000-1099 codes for account DAO exceptions. */
	CANNOT_FIND_ACCOUNT_BY_USERNAME("SPA-1000", "Cannot find account by username."),
	CANNOT_FIND_ACCOUNT_BY_EMAIL("SPA-1001", "Cannot find account by email."),
	CANNOT_FIND_ALL_ACCOUNTS("SPA-1002", "Cannot find all accounts."),
	
	/** 1100-1199 codes for profile DAO exceptions. */
	CANNOT_FIND_PROFILE_BY_EMAIL("SPA-1100", "Cannot find profile by email."),

	/** 1200-1299 codes for token DAO exceptions. */
	CANNOT_FIND_SESSION_BY_ACCESS_TOKEN("SPA-1200", "Cannot find session by access token."),
	
	/** 1300-1399 codes for mobile app DAO exceptions. */
	CANNOT_FIND_ALL_MOBILE_APPS("SPA-1300", "Cannot find all mobile applications."),
	
	/** 1400-1499 codes for order DAO exceptions. */
	CANNOT_FIND_ALL_ORDERS("SPA-1400", "Cannot find all orders."),
	CANNOT_FIND_ORDERS_BY_ACCOUNT_ID("SPA", "Cannot find orders with specified account id.")

	;

	private SpastructureExceptionDefinition exceptionDefinition;

	private SpastructureDBRepositoryExceptionCreator (String code, String message) {

		this.exceptionDefinition = new SpastructureExceptionDefinition(code, message,
				SpastructureExceptionType.DB_REPOSITORY);
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
	public SpastructureDBRepositoryException createException () {

		return new SpastructureDBRepositoryException(exceptionDefinition);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public SpastructureDBRepositoryException createException (Throwable cause) {

		return new SpastructureDBRepositoryException(exceptionDefinition, cause);
	}

}
