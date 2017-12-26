/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test.extend;

/**
 * <p>
 * ÀàÃèÊö:
 * <p>
 * 
 * ËùÊô°ü:org.guanmu.test.extend
 * @author guanmu 2017-12-26
 * 
 */
public class Parent {
	
	protected static String lastname = "Parent";
	
	protected String lastnameFild = "Parent";
	
	public static String extend = "extend";	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println(lastname);
		System.out.println(lastnameFild);
	}
}
