package com.client.ShoppersStack.Serialization;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerialization 
{
public static void main(String[] args) throws StreamWriteException, DatabindException, IOException 
{
	File filePath = new File("jsonObj.json");
	JacksonJavaObject jackObj = new JacksonJavaObject("haque", "trainer", 2023);
	ObjectMapper objM=new ObjectMapper();
	objM.writeValue(filePath, jackObj);
}
}
