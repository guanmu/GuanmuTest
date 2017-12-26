/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test.extend;


/**
 * <p>
 * ������:���Ը��������ͬ�����Ը��Ǻ;�̬��ص����⡣
 * 
 * ���ۣ�
 * 	1������͸��ඨ����ͬ��ͬ��������ԣ�û����ȷ���޶�������£�ÿ������ֻ��ʹ�ñ�����������ԣ����漰���Ը��ǡ�
 * 	2�����ඨ��ľ�̬�������������õ��Ǹ���ľ�̬��������
 * <p>
 * 
 * ������:org.guanmu.test.extend
 * @author guanmu 2017-12-26
 * 
 */
public class Child extends Parent {

	static {
		extend = "Child-extend";
	}
	
	protected static String lastname = "Child";

	protected String lastnameFild = "Child";	
	
	
	
	/**
	 * 
	 */
	public Child() {
		super.lastnameFild = "Child-lastnameFild";
		Parent.lastname = "Child-lastname";
	
		lastname = "lastname";
		lastnameFild = "lastnameFild";
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		c.print();
		
		System.out.println(Parent.extend);
		System.out.println(Child.extend);
		
	}
}
