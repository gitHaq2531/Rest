package com.client.ShoppersStack.Login;

import org.testng.annotations.Test;

import com.client.ShoppersStack.GenericUtility.FileUtility;
import com.client.ShoppersStack.endPoints.IEndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class ShoppersLoginTest 
{
	public static String token;
	public static String shopperId;
@Test
public void loginTest() throws IOException
{
	FileUtility fLib=new FileUtility();
	JSONObject jObj=new JSONObject();
	jObj.put("email",fLib.getDataFromProperty("email"));
	jObj.put("password", fLib.getDataFromProperty("password"));
	jObj.put("role", fLib.getDataFromProperty("role"));
	
	Response resp = given()
						.contentType(ContentType.JSON)
						.body(jObj)
					.when()
		.post(fLib.getDataFromProperty("ShoppersBaseUrl")+IEndPoints.userLogin);
	resp.then().log().all();
	
	token = resp.jsonPath().get("data.jwtToken");
	shopperId = resp.jsonPath().getString("data.userId");
	
	System.out.println("========================");
}
}
