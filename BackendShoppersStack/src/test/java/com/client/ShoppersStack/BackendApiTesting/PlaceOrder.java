package com.client.ShoppersStack.BackendApiTesting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.PojoUtility.PojoAddAddress;
import com.client.ShoppersStack.endPoints.IEndPoints;
import io.restassured.response.Response;

public class PlaceOrder extends BaseApiUtils
{
	Object itemId;
	Object orderId;
	
	@Test(priority = 1)
	public void addToCart()
	{
		System.out.println("============================add to cart====");
		AddTocartObject cartObj=new AddTocartObject(16, 1);
		
		Response resp = given()
			.spec(reqSpec)
			.body(cartObj)
		.when()
			.post(IEndPoints.addToCart);
		resp.then()
			.log().all();
		itemId = resp.jsonPath().get("data.itemId");
		System.out.println("itemId : "+itemId);
	}
	
	public static Object addressId;
	@Test(priority = 2)
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
	
	@Test(priority = 3)
	public void placeOrderTest()
	{
		System.out.println("=========addressId : "+addressId);
		Address address = new Address(addressId);
		PojoPlaceOrder orderObj = new PojoPlaceOrder(address, "COD");
		
		Response resp = given()
			.spec(reqSpec)
			.body(orderObj)
		.when()
			.post(IEndPoints.placeOrder);
		resp.then()
			.log().all();
		orderId = resp.jsonPath().get("data.orderId");
	}
	
	@Test(priority = 4)
	public void displayOrderHistory()
	{
		System.out.println("============order history===========");
		given()
			.spec(reqSpec)
		.when()
			.get(IEndPoints.orderHistory)
		.then()
			.log().all();
	}

	@Test(priority = 5)
	public void updateOrderStatus()
	{
		System.out.println("=========update status=============");
		given()
			.queryParam("status", "DELIVERED")
			.spec(reqSpec)
		.when()
			.patch(IEndPoints.updateOrderHistory+orderId)
		.then()
			.log().all();
		
	}

	@Test(priority = 6)
	public void generateInvoice()
	{
		System.out.println("================invoice====================");
		given()
			.spec(reqSpec)
		.when()
			.get(IEndPoints.generateInvoice+orderId+"/invoice")
		.then()
			.log().all();
	}
}
