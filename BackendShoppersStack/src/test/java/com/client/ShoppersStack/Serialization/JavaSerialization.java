package com.client.ShoppersStack.Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JavaSerialization 
{

	public static void main(String[] args) throws IOException 
	{
		JavaObject jObj=new JavaObject("afzaul", "sofftware engineer", 2023);
		FileOutputStream fos=new FileOutputStream("./binary.txt");
		ObjectOutputStream objOut=new ObjectOutputStream(fos);
		objOut.writeObject(jObj);
	}
}
