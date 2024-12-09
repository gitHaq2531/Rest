package com.client.ShoppersStack.BackendApiTesting;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import static com.client.ShoppersStack.endPoints.IEndPoints.*;

import static io.restassured.RestAssured.*;

public class ProductsTest extends BaseApiUtils
{
@Test
public void viewProducts()
{
	given()
		.spec(reqSpec)
	.when()
		.get(viewProducts)
	.then()
		.assertThat().statusCode(200)
		.log().all();
}

@Test
public void verifyProduct()
{
	given()
		.spec(reqSpec)
	.when()
		.get(verifyProduct)
	.then()
		.assertThat().body("data[0].name",Matchers.equalTo("POND's Bright Beauty Serum Cream Anti-Spot Fairness SPF"));				
}
}
