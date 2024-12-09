package com.client.ShoppersStack.BackendApiTesting;

import org.testng.annotations.Test;
import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.endPoints.IEndPoints;
import static io.restassured.RestAssured.*;

public class OrderTest extends BaseApiUtils
{
	
@Test
public void placeOrderTest()
{
	System.out.println("=============placing order================");
	System.out.println("=========addressId : "+ AddressTest.addressId);
	Address address = new Address(AddressTest.addressId);
	PojoPlaceOrder orderObj = new PojoPlaceOrder(address, "COD");
	
	given()
		.spec(reqSpec)
		.body(orderObj)
	.when()
		.post(IEndPoints.placeOrder)
	.then()
	.assertThat().statusCode(201)
		.log().all();
	System.out.println("============order placed successfull============================");
}
}
