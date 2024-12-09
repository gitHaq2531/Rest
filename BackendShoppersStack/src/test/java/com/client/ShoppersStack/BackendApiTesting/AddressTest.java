package com.client.ShoppersStack.BackendApiTesting;

import org.testng.annotations.Test;

import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.PojoUtility.PojoAddAddress;
import com.client.ShoppersStack.PojoUtility.PojoUpdateAddress;
import com.client.ShoppersStack.endPoints.IEndPoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddressTest extends BaseApiUtils
{
	
	public static Object addressId;
	@Test
	public void addAddress()
	{
		System.out.println("====addAddress============");
		PojoAddAddress addressObj = new PojoAddAddress("haque mansion", "Daltonganj", "india", "river", "Afzaul", "6206861440", "560010", "jharkhand", "river side", "home");
		
		Response resp = given()
			.spec(reqSpec)
			.body(addressObj)
		.when()
			.post(IEndPoints.addAddress);
		resp.then()
			.log().all()
			.assertThat().statusCode(201);
		
		addressId = resp.jsonPath().get("data.addressId");
		System.out.println("addressId is : "+addressId);
	}
	
	@Test
	public void getAlladdresses()
	{
		System.out.println("==========get all address==========");
		given()
			.spec(reqSpec)
		.when()
			.get(IEndPoints.getAllAddresses)
		.then()
			.log().all()
			.assertThat().statusCode(200);
	}
	
	@Test(dependsOnMethods = "addAddress")
	public void getParticularAddress()
	{
		System.out.println("========getParticular address==========");
		System.out.println(addressId);
		given()
			.spec(reqSpec)
		.when()
			.get(IEndPoints.getParticularAddress+addressId)
		.then()
			.log().all()
			.assertThat().statusCode(200);
	}
	
	@Test(dependsOnMethods = "addAddress")
	public void updateAddress()
	{
		
		PojoUpdateAddress updateAddress = new PojoUpdateAddress(addressId, "abc", "cde", "india", "efg", "ghi", "6206861440", "560010", "jh", "river", "home");
		given()
			.spec(reqSpec)
			.body(updateAddress)
		.when()
			.put(IEndPoints.updateAddress+addressId)
		.then()
			.log().all();
	}
}