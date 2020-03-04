package com.restassured.example;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_REQUEST_PRINTALLHEADERS {

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
		/*
		List<Header> headers = response.headers().asList();
		
		for(Header header:  headers) {
			System.out.println(header);
		}
		*/
		Headers headers = response.headers();
		for(Header header: headers) {
			System.out.println(header.getName() + " :::::: " + header.getValue());
		}
	}
	
}
