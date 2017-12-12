/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test;

import org.guanmu.log.Loggers;
import org.slf4j.Logger;

/**
 * <p>
 * ������:���a++��++a�ľ���ʵ�ַ�ʽ������ʹ�����������塣
 * <p>
 * 
 * ������:org.guanmu.test
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
		 * a = ++a ��eclipse�л����"The assignment to variable a has no effect"�澯�����ʽ��ֵ��aû��Ч����ԭ����++a�ķ���ֵ����a����
		 * 
		 * �ȼ�����
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
		 * a++ �����ڵ��� valueSelfAdd(a)
		 * a=a++�����������´���
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
