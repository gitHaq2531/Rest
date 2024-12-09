package com.client.ShoppersStack.GenericUtility;

import java.util.List;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

public class JsonUtility 
{
public String getDataOnJsonBody(Response resp,String jsonpath)
{
	String data = resp.jsonPath().get(jsonpath);
	return data;
}

public void verifyDataInJsonBody(Response resp,String jsonpath,String expectedData)
{
	List<String> list = JsonPath.read(resp.asString(), jsonpath);
	boolean flag=false;
	for(String lst : list)
	{
		if(lst.equals(expectedData))
		{
			System.out.println(expectedData+" is verified : Passed");
			flag=true;
			break;
		}
	}
	if(flag==false)
	{
		System.out.println(expectedData+" is not verified : Failed");
	}
}
}
