package com.client.ShoppersStack.BackendApiTesting;

import org.testng.annotations.Test;
import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.endPoints.IEndPoints;
import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import java.io.IOException;

public class WishlistTest extends BaseApiUtils
{
	
	public static int productId=16;
@Test
public void addToWishlistTest() throws IOException
{
	System.out.println("============add to wishlist started===========");
	JSONObject jObj=new JSONObject();
	jObj.put("productId", productId);
	jObj.put("quantity", 0);
	
	given()
		.spec(reqSpec)
		.body(jObj)
	.when()
		.post(IEndPoints.addToWishlist)
		.then()
		.assertThat().statusCode(201)
		.log().all();
	System.out.println("===================ended==============");
}

@Test
public void deleteFromWishlist()
{
	System.out.println("==========delete from wishlist started=============");
	given()
		.spec(reqSpec)
	.when()
		.delete(IEndPoints.deleteFromWishlist+productId)
	.then()
		.assertThat().statusCode(204)
		.log().all();
}
}
