package com.restassured.example;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.utils.ExcelUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriverTest_NewEmployee {

	@Test(dataProvider = "empdataprovider")
	void postNewEmployees(String ename, String eage, String esal) {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		/*
		requestParams.put("name", "Kamala");
		requestParams.put("salary", "123");
		requestParams.put("age", "23");
		*/
		requestParams.put("name", ename);
		requestParams.put("salary", eage);
		requestParams.put("age", esal);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST, "/create");
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@DataProvider(name="empdataprovider")
	String[][] getEmpData() throws IOException {
		
		String path = "D:/datadriven.xlsx";
		int rowCount = ExcelUtils.getRowCount(path, "Sheet1");
		int colcount = ExcelUtils.getCellCount(path, "Sheet1", rowCount);
		
		String empData[][] =  new String[rowCount][colcount];

		
		for(int i = 1; i <= rowCount; i++) {
			for(int j = 0; j < colcount; j++) {
				empData[i-1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		//String empData[][] = {{"Kamala","100000","30"},{"Samraj","200000","32"},{"Augustin","300000","32"}};
		return empData;
	}

}
