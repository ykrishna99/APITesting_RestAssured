package com.ra.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserList1 {

	@Test
	void test1() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println("==============================");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

	}

	@Test
	void test2() {

		RestAssured.baseURI = "https://reqres.in/api/users";

		Response response = null;
		response = RestAssured.given().when().get("?page=2");

		System.out.println("Response is :\n" + response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		System.out.println(response.getStatusCode());

		Assert.assertEquals(statusCode, 200);

	}

}
