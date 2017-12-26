/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test.extend;


/**
 * <p>
 * 类描述:测试父类和子类同名属性覆盖和静态相关的问题。
 * 
 * 结论：子类和父类定义了同名同级别的属性，没有明确类限定的情况下，每个类中只会使用本类自身的属性，不涉及属性覆盖。
 * 
 * <p>
 * 
 * 所属包:org.guanmu.test.extend
 * @author guanmu 2017-12-26
 * 
 */
public class Child extends Parent {

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
	}
}
