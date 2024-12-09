package com.client.ShoppersStack.BackendApiTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.endPoints.IEndPoints;

public class DeleteTest extends BaseApiUtils
{
	@Test
	public void deleteAddress()
	{
		given()
		.spec(reqSpec)
			.delete(IEndPoints.deleteAddress+AddressTest.addressId)
		.then()
			.log().all();
		System.out.println(AddressTest.addressId);
		
	}
}
