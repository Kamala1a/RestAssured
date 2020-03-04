package com.restassured.example;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidateJSONResponse {

	@Test
	void validateJSONResponse() {
		
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city"; 
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/Chennai");
		
		JsonPath jsonPath = response.jsonPath();
		System.out.println("City: " + jsonPath.get("City"));
		System.out.println("Temperature: " + jsonPath.get("Temperature"));
		System.out.println("Temperature: " + jsonPath.get("Temperature"));
		System.out.println("Humidity: " + jsonPath.get("Humidity"));
		System.out.println("WeatherDescription: " + jsonPath.get("WeatherDescription"));
		System.out.println("WindSpeed: " + jsonPath.get("WindSpeed"));
		System.out.println("WindDirectionDegree: " + jsonPath.get("WindDirectionDegree"));
		
		Assert.assertEquals(jsonPath.get("City"), "Chennai");
	}
	
}
