package com.client.ShoppersStack.BackendApiTesting;

import static io.restassured.RestAssured.given;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.client.ShoppersStack.BaseApiUtility.BaseApiUtils;
import com.client.ShoppersStack.endPoints.IEndPoints;

import io.restassured.response.Response;

public class CartTestWithGUI extends BaseApiUtils
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
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.shoppersstack.com/");
		driver.findElement(By.id("loginBtn")).click();
		WebElement usernameEdt = driver.findElement(By.id("Email"));
		usernameEdt.clear();
		usernameEdt.sendKeys("afzaulhaque1@gmail.com");
		WebElement passwordEdt = driver.findElement(By.id("Password"));
		passwordEdt.clear();
		passwordEdt.sendKeys("Shoppers@123");
		driver.findElement(By.id("Login")).submit();
		
		WebElement cartIcon = driver.findElement(By.id("cart"));
		cartIcon.click();
		driver.findElement(By.linkText("Home")).click();
		cartIcon.click();
		
		WebElement pondsItem= driver.findElement(By.xpath("//p[text()='PONDs Bright Beauty Serum Cream Anti Spot Fairness SPF']"));
		if(pondsItem.isDisplayed())
		{
			System.out.println("===========product displayed===========");
		}
		else {
			System.out.println("============not displayed============");
		}
	}

}
