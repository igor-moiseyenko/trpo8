package com.imoiseyenko.spastructure.backend.service.profile.exception.creator;

import com.imoiseyenko.spastructure.backend.service.profile.exception.SpastructureProfileServiceException;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionCreator;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionDefinition;
import com.imoiseyenko.spastructure.common.exception.SpastructureExceptionType;

/**
 * Spastructure profile service exception creator.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public enum SpastructureProfileServiceExceptionCreator implements SpastructureExceptionCreator {

	/** 2000-2999 codes for profile service layer exceptions. */

	/** 2000-2099 codes for account service exceptions. */
	CANNOT_CREATE_ACCOUNT("SPA-2000", "Cannot create account."),
	CANNOT_GET_ACCOUNT("SPA-2001", "Cannot get account."),
	CANNOT_UPDATE_ACCOUNT("SPA-2002", "Cannot update account."),
	CANNOT_DELETE_ACCOUNT("SPA-2003", "Cannot delete account."),
	CANNOT_GET_ACCOUNT_BY_USERNAME("SPA-2004", "Cannot get account by username."),
	CANNOT_GET_ACCOUNT_BY_EMAIL("SPA-2005", "Cannot get account by email."),
	CANNOT_GET_ALL_ACCOUNTS("SPA-2006", "Cannot get all accounts."),
	CANNOT_LOGIN("SPA-2007", "Cannot log in."),
	INVALID_USERNAME_OR_PASSWORD("SPA-2008", "Invalid username or password."),
	CANNOT_SIGN_OUT("SPA-2009", "Cannot sign out."),

	/** 2100-2199 codes for profile service exceptions. */
	CANNOT_CREATE_PROFILE("SPA-2000", "Cannot create profile."),
	CANNOT_GET_PROFILE("SPA-2001", "Cannot get profile."),
	CANNOT_UPDATE_PROFILE("SPA-2002", "Cannot update profile."),
	CANNOT_DELETE_PROFILE("SPA-2003", "Cannot delete profile."),
	CANNOT_REGISTER("SPA-2004", "Cannot register."),
	USERNAME_ALREADY_EXIST("SPA-2005", "Username already exist."),
	CANNOT_GET_PROFILE_BY_EMAIL("SPA-2006", "Cannot get profile by email."),

	/** 2200-2299 codes for token service exceptions. */
	CANNOT_VERIFY_TOKEN("SPA-2200", "Cannot verify token."),
	INVALID_TOKEN_EXPIRATION_TIME("SPA-2201", "Invalid token expiration time."),
	SESSION_DOES_NOT_EXIST("SPA-2202", "Session doesn't exist."),
	YOU_HAVE_TO_LOGIN_FIRST("SPA-2203", "You have to login first.");

	private SpastructureExceptionDefinition exceptionDefinition;

	private SpastructureProfileServiceExceptionCreator (String code, String message) {

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
	public SpastructureProfileServiceException createException () {

		return new SpastructureProfileServiceException(exceptionDefinition);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public SpastructureProfileServiceException createException (Throwable cause) {

		return new SpastructureProfileServiceException(exceptionDefinition, cause);
	}

}
