package com.client.ShoppersStack.BaseApiUtility;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.client.ShoppersStack.GenericUtility.FileUtility;
import com.client.ShoppersStack.endPoints.IEndPoints;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApiUtils 
{
	public static String token;
	public static String shopperId;
	public RequestSpecification reqSpec;
	FileUtility fLib=new FileUtility();
	public String baseURI;

	
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		System.out.println("========before suite executed====");
		//report config
		//database connect
		baseURI = fLib.getDataFromProperty("ShoppersBaseUrl");
		JSONObject jObj= new JSONObject();
		jObj.put("email",fLib.getDataFromProperty("email"));
		jObj.put("password", fLib.getDataFromProperty("password"));
		jObj.put("role", fLib.getDataFromProperty("role"));
		
		Response resp = given()
							.contentType(ContentType.JSON)
							.body(jObj)
						.when()
			.post(baseURI+IEndPoints.userLogin);
		token = resp.jsonPath().get("data.jwtToken");
		shopperId = resp.jsonPath().getString("data.userId");
	}
	
@BeforeClass
public void beforeClass() throws IOException
{	
	RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
	reqBuilder.setContentType(ContentType.JSON);
	reqBuilder.setAuth(RestAssured.oauth2(token));
	reqBuilder.setBaseUri(fLib.getDataFromProperty("ShoppersBaseUrl"));
	reqSpec = reqBuilder.build();
	
}


@AfterSuite
public void afterSuite()
{
	//report saved...
	//close database connection...
}

@AfterClass
public void afterClass()
{
	//logout...
}
}
