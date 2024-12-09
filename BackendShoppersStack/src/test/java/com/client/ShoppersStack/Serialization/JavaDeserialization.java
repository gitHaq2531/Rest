package com.client.ShoppersStack.Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JavaDeserialization 
{
public static void main(String[] args) throws IOException, ClassNotFoundException 
{
	FileInputStream fis=new FileInputStream("./binary.txt");
	ObjectInputStream objIn = new ObjectInputStream(fis);
	JavaObject jObj = (JavaObject)objIn.readObject();
	System.out.println(jObj.name);
}
}
