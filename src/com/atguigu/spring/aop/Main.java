package com.atguigu.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)ctx.getBean("arithmeticCalculator");
		System.out.println(arithmeticCalculator.getClass().getName());
		int result = arithmeticCalculator.add(3, 4);
		System.out.println("result: "+result);
		result = arithmeticCalculator.div(200,10);
		System.out.println("result: "+result);
	}
}
