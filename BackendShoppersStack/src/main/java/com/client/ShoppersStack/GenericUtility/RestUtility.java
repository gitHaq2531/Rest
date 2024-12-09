package com.client.ShoppersStack.GenericUtility;

import org.hamcrest.Matchers;

import io.restassured.response.Response;

public class RestUtility 
{

	public void verifyResponseTimeLessThan(Response resp, long maxTime){
		resp.then().assertThat().time(Matchers.lessThan(maxTime));
	}
	
	public void verifyResponseTimeGreaterThan(Response resp, long minTime) {
		resp.then().assertThat().time(Matchers.greaterThan(minTime));
	}
	
	public void verifyStatusCode(Response resp,int statusCode) {
		resp.then().assertThat().statusCode(statusCode);
	}
	
}
