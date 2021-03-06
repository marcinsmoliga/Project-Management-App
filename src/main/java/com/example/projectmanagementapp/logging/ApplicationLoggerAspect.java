package com.example.projectmanagementapp.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.example.projectmanagementapp.controller..*)")

	public void definePackagePointcuts() {

	}

	@After("definePackagePointcuts()")
	public void logAfter(JoinPoint joinPoint) {
		log.debug("\n \n \n");
		log.debug("***** Before Method Execution ***** \n {}.{} with arguments[s] = {}",
				joinPoint.getSignature().getDeclaringType(),
				joinPoint.getSignature().getName(),
				Arrays.toString(joinPoint.getArgs()));
		log.debug("________________________________________________________ \n \n \n");
	}

	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint joinPoint) {
		log.debug("\n \n \n");
		log.debug("***** Before Method Execution ***** \n {}.{} with arguments[s] = {}",
				joinPoint.getSignature().getDeclaringType(),
				joinPoint.getSignature().getName(),
				Arrays.toString(joinPoint.getArgs()));
		log.debug("________________________________________________________ \n \n \n");

		Object object = null;
		try {
			object = joinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		log.debug("\n \n \n");
		log.debug("***** After Method Execution ***** \n {}.{} with arguments[s] = {}",
				joinPoint.getSignature().getDeclaringType(),
				joinPoint.getSignature().getName(),
				Arrays.toString(joinPoint.getArgs()));
		log.debug("________________________________________________________ \n \n \n");

		return object;
	}
}
