package com.client.ShoppersStack.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
public String getDataFromProperty(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("ShoppersEnvConfig.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	String data = pObj.getProperty(key);
	return data;
}
}
