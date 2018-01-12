/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.model;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * <p>
 * ÀàÃèÊö:
 * <p>
 * 
 * ËùÊô°ü:org.guanmu.model
 * @author guanmu 2018-1-11
 * 
 */
public class Student {
	
	private String namge;
	
	private int age;
	
	private String secrect;


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String namge, int age, String secrect) {
		super();
		this.namge = namge;
		this.age = age;
		this.secrect = secrect;
	}

	public String getNamge() {
		return namge;
	}

	public void setNamge(String namge) {
		this.namge = namge;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@JsonIgnore
	public String getSecrect() {
		return secrect;
	}

	public void setSecrect(String secrect) {
		this.secrect = secrect;
	}
	
	
	
}
