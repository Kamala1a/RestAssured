package com.restassured.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {

	@Test
	void verifyHeaders() {

		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city"; 
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/Chennai");

		//Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		//Captures details of header from response
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json");
		
		String contentLength = response.header("Content-Length");
		Assert.assertEquals(contentLength, "168");

	}

}
