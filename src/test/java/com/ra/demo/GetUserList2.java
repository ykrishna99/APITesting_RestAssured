package com.ra.demo;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetUserList2 {

	@Test
	void test1() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	void test2() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(9));
	
	}

}
