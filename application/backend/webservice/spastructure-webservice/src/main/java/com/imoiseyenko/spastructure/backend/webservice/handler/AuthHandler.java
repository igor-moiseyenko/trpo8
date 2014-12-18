//package com.imoiseyenko.spastructure.backend.webservice.handler;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.imoiseyenko.spastructure.backend.service.profile.TokenService;
//import com.imoiseyenko.spastructure.common.exception.SpastructureException;
//
///**
// * Authentication & authorization handler.
// * 
// * @author imoiseyenko93@gmail.com
// * @version Apr 27, 2014
// */@Aspect
//public class AuthHandler {
//
//	@Autowired
//	private TokenService tokenService;
//
//	@Pointcut("execution(* com.imoiseyenko.spastructure.backend.webservice..*.*(..)) && args(tokenData,..) && !execution(* com.imoiseyenko.spastructure.backend.webservice..*.login(..)) && !execution(* com.imoiseyenko.spastructure.backend.webservice..*.register(..))")
//	public void controllerMethod (String tokenData) {
//	}
//
//	@Before("controllerMethod(tokenData)")
//	public void beforeControllerMethod (String tokenData) throws SpastructureException {
//
//		tokenService.verifyToken(tokenData);
//	}
//}
