package com.restassured.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST {

	@Test
	void getWeatherDetails() {
		
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city"; 
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/Chennai");
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains("Chennai"), true);
		
		
	}
	
}
