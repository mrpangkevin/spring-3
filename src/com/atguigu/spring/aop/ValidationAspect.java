package com.atguigu.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class ValidationAspect {

//	@Before("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int,int))")
	@Before("LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("Validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
