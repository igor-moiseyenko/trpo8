package com.imoiseyenko.spastructure.backend.webservice.exception.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import com.imoiseyenko.spastructure.common.exception.SpastructureException;

/**
 * {@link SpastructureException} exception handler.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
@ControllerAdvice
public class SpastructureExceptionHandler {

	@ExceptionHandler({ SpastructureException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleSpastructureException (SpastructureException ex) {

		return new ModelAndView(new MappingJackson2JsonView(), createUnmodifiableMap("error",
				ex.getExceptionDefinition()));
	}

	private <Key, Value> Map<Key, Value> createUnmodifiableMap (Key name, Value value) {

		Map<Key, Value> map = new HashMap<>();
		map.put(name, value);

		return Collections.unmodifiableMap(map);
	}
}
