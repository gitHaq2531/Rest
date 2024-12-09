package com.client.ShoppersStack.BackendApiTesting;

import org.testng.annotations.Test;

import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.PojoUtility.PojoReview;
import com.client.ShoppersStack.endPoints.IEndPoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReviewTest extends BaseApiUtils
{
	int productId=16;
	Object reviewId;
	@Test(priority = 1)
	public void addReviews()
	{
		System.out.println("=============addReview===============");
		PojoReview reviewObj=new PojoReview("very nyc product", "amazing", "4", shopperId, "haque");
		
		Response resp = given()
			.queryParam("productId", productId)
			.spec(reqSpec)
			.body(reviewObj)
		.when()
			.post(IEndPoints.addReview);
		
		resp.then()
			.log().all();
		reviewId = resp.jsonPath().get("data.reviewId");
	}
	
	@Test(priority = 2)
	public void getreviews()
	{
		System.out.println("================get review==========");
		given()
			.spec(reqSpec)
		.when()
			.get(IEndPoints.getReviews+productId)
		.then()
			.log().all();
	}
	
	@Test(priority = 3)
	public void updateReview()
	{
		System.out.println("===============update review=============");
		PojoReview reviewObj = new PojoReview("achha hai", "niceee", "3", shopperId, "afz");
		given()
			.queryParam("productId", productId)
			.spec(reqSpec)
			.body(reviewObj)
		.when()
			.put(IEndPoints.updateReviews+reviewId)
		.then()
			.log().all()
			.assertThat().statusCode(200);
	}
	
	@Test(priority = 4)
	public void deleteReview()
	{
		System.out.println("=================delete review");
		given()
			.queryParam("productId", productId)
			.spec(reqSpec)
		.when()
			.delete(IEndPoints.deleteReview+reviewId)
		.then()
			.log().all();
	}
}
