package com.imoiseyenko.spastructure.common.exception;

import java.io.Serializable;

/**
 * Spastructure exception definition.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
public class SpastructureExceptionDefinition implements Serializable {

	/** Serial version id. */
	private static final long serialVersionUID = 1L;

	/** Exception code. */
	private String code;

	/** Exception message. */
	private String message;

	/** Exception type. */
	private SpastructureExceptionType type;

	public SpastructureExceptionDefinition (String code, String message,
			SpastructureExceptionType type) {

		this.code = code;
		this.message = message;
		this.type = type;
	}

	public SpastructureExceptionDefinition (SpastructureExceptionDefinition definition) {

		this(definition.code, definition.message, definition.type);
	}

	public String getCode () {
		return code;
	}

	public void setCode (String code) {
		this.code = code;
	}

	public String getMessage () {
		return message;
	}

	public void setMessage (String message) {
		this.message = message;
	}

	public SpastructureExceptionType getType () {
		return type;
	}

	public void setType (SpastructureExceptionType type) {
		this.type = type;
	}
}
