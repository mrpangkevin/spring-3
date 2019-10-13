package com.atguigu.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
	public void declareJointPointExpression() {		
	}
	
	//@Before("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		System.out.println("The method [" + methodName +"] begins with " + Arrays.asList(args));
	}
	
	//@After("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		System.out.println("The method [" + methodName + "] ends with " + Arrays.asList(args));
	}
//	@AfterReturning(value="execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int,int))",
//			returning="result")
	@AfterReturning(value="declareJointPointExpression()",returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodMethod = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		System.out.println("The method [" + methodMethod + "] returns with " + Arrays.asList(args) + " result is " + result);
	}
	
//	@AfterThrowing(value="execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int,int))",
//			throwing="ex")
	@AfterThrowing(value="declareJointPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method [" + methodName + "] throws with " + ex);
	}
	
//	@Around("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
//	@Around("declareJointPointExpression()")
//	public Object aroundMethod(ProceedingJoinPoint pjd) {
//		System.out.println("aroundMethod");
//		Object result = null;
//		String methodName = pjd.getSignature().getName();
//		try {
//			System.out.println("The method [" + methodName + "] begins with " + Arrays.asList((pjd.getArgs())));
//			result = pjd.proceed();
//			System.out.println("The method [" + methodName + "] returns with " + result);
//		} catch (Throwable e) {
//			// TODO: handle exception
//			System.out.println("The method [" + methodName + "] throws with " + e.toString());
//		}
//		System.out.println("The method [" + methodName + "] ends with ");
//		return result;
//	}
}
