/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test;

import org.guanmu.log.Loggers;
import org.slf4j.Logger;

/**
 * <p>
 * ¿‡√Ë ˆ:
 * <p>
 * 
 * À˘ Ù∞¸:org.guanmu.test
 * @author guanmu 2017-12-12
 * 
 */
public class PassByReferenceTest {
	
	private static final Logger logger = Loggers.getLog(PassByReferenceTest.class.getName());
	
	public static void main(String[] args) {
		int a = 99;
		
		passByValueTest(a);
		
		logger.debug("main:"+a);
		
		passByValueTest2(a);

		logger.debug("main2:"+a);		
		
	}

	private static void passByValueTest2(int a) {
		a = a++;
		
		logger.debug("a is [{}]",a);
		
		int b = a++;
		
		logger.debug("a is [{}]",a);
		logger.debug("b is [{}]",b);
	}

	private static void passByValueTest(int a) {
		
		a = a + 1;
		
		logger.debug("a is [{}]",a);
	}
	
}
