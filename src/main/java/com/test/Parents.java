package com.test;

import org.testng.annotations.BeforeClass;

public class Parents {
	public String parent;

	public Parents(){
	
	System.out.println("这是父类构造方法");
	parent="gouzao";
}

@BeforeClass
public void testBeforeclass(){
	System.out.println("这是beforeclass");
	parent="before";
}
}
