package com.springboot.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class Log {

	@Before(value = "execution(* com.springboot..*(..))")
	public void beforeLogging(JoinPoint joinPoint) {
		log.info("Enterd into : {}", joinPoint.toShortString());
	}
}
