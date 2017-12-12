/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test;

import org.guanmu.log.Loggers;
import org.slf4j.Logger;

/**
 * <p>
 * 类描述:理解a++和++a的具体实现方式，避免使用中碰见陷阱。
 * <p>
 * 
 * 所属包:org.guanmu.test
 * @author guanmu 2017-12-12
 * 
 */
public class IntSelfAdditionTest {

	private static final Logger logger = Loggers.getLog(IntSelfAdditionTest.class.getName());
	
	public static void main(String[] args) {
		
		trap1();
		
		trap2();
	}

	/**
	 * 
	 */
	private static void trap2() {
		int a = 99;
		
		a = ++a;
			
		/*
		 * a = ++a 在eclipse中会出现"The assignment to variable a has no effect"告警，表达式赋值给a没有效果，原因是++a的返回值就是a本身
		 * 
		 * 等价如下
		 * 
		 * a = a + 1;
		 * 
		 * int tmp = a;
		 * 
		 * a = tmp;
		 * 
		 */
		logger.info("step3 a is [{}]",a);	
	}

	/**
	 * 
	 */
	private static void trap1() {
		int a = 99;
		
		logger.info("step1 a is [{}]",a);
		
		a = a++;
		
		/*
		 * a++ 类似于调用 valueSelfAdd(a)
		 * a=a++则类似于如下代码
		 * 
		 * int tmp = a;
		 * 
		 * a = a + 1;
		 * 
		 * a = tmp
		 */
		logger.info("step2 a is [{}]",a);
		
	}

	/**
	 * @param a
	 */
	public static int valueSelfAdd(int a) {
		int tmp = a;
		
		a = a + 1;
		
		return tmp;
	}
	
	
}
