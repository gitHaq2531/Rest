package com.client.ShoppersStack.BackendApiTesting;

import org.testng.annotations.Test;
import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.endPoints.IEndPoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CartTest extends BaseApiUtils
{
	public static Object itemId;
	int productId=16;
	public AddTocartObject cartObject;
@Test
public void addToCart()
{
	System.out.println("===add to cart====");
	cartObject = new AddTocartObject(productId, 1);
	
	Response resp = given()
		.spec(reqSpec)
		.body(cartObject)
	.when()
		.post(IEndPoints.addToCart);
	System.out.println(resp.getStatusCode());
	resp.then()
		.log().all();
	itemId = resp.jsonPath().get("data.itemId");
	System.out.println("itemId : "+itemId);
}

@Test
public void getProductFromCart()
{
	System.out.println("===get from cart===");
	given()
		.spec(reqSpec)
		.get(IEndPoints.getProductFromCart)
	.then()
		.log().all()
		.assertThat().statusCode(200);
}

@Test
public void updateProdInCart()
{
	System.out.println("====update cart====");
	UpdateCartObject updateObj=new UpdateCartObject(productId, 5);
	given()
		.spec(reqSpec)
		.body(updateObj)
	.when()
		.put(IEndPoints.updateProductInCart+itemId)
	.then()
	.log().all()
		.statusCode(200);
}
}
