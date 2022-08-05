package com.ra.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class GetUserList5 {

	@Test
	public void test1() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
	}

	@Test
	public void test2() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7)).log()
				.all();
	}

	@Test
	public void test3() {

		given().param("Key", "values").header("key", "value").get("https://reqres.in/api/users?page=2").then()
				.statusCode(200).log().all().body("data.first_name", hasItems("Michael", "Lindsay"));
	}

}
