package com.imoiseyenko.spastructure.backend.webservice.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * Cross Origin Requests Sharing filter.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
@Component
public class CORSFilter implements Filter {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void destroy () {
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "token_data");

		filterChain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @author imoiseyenko93@gmail.com
	 */
	@Override
	public void init (FilterConfig arg0) throws ServletException {
	}

}
