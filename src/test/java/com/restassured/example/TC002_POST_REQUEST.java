package com.restassured.example;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST {

	@Test
	void RegistrationSuccessful() {
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer"; 
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request Parameters (or) Body (or) Request Payload sending along with Post Request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "jhsjsls");
		requestParams.put("LastName", "jhsjsls");
		requestParams.put("UserName", "jhsjsls");
		requestParams.put("Password", "jhsjsls");
		requestParams.put("Email", "jhsjsls@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST, "/register");
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);
	
		
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
	
}
