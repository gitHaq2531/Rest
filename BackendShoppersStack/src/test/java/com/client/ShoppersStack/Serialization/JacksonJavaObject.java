package com.client.ShoppersStack.Serialization;

public class JacksonJavaObject
{

	String name;
	String designation;
	int yop;
	
	//public JacksonJavaObject() {}
	public JacksonJavaObject(String name, String designation, int yop) 
	{
		super();
		this.name = name;
		this.designation = designation;
		this.yop = yop;
	}
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public int getYop() {
		return yop;
	}
	
	
}
