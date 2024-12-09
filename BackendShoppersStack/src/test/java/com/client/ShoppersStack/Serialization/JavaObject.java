package com.client.ShoppersStack.Serialization;

import java.io.Serializable;

public class JavaObject implements Serializable
{

	String name;
	String designation;
	int yop;
	
	public JavaObject(String name, String designation, int yop) 
	{
		super();
		this.name = name;
		this.designation = designation;
		this.yop = yop;
	}
}
