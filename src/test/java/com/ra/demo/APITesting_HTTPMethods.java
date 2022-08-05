package com.ra.demo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class APITesting_HTTPMethods {

	@Test
	public void testPost() {

		JSONObject request = new JSONObject();

		request.put("name", "Krishna");
		request.put("role", "Test Lead");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);

	}

	@Test
	public void testPut() {

		JSONObject request = new JSONObject();

		request.put("name", "Krishna");
		request.put("job", "Test Lead");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("https://reqres.in/api/users").then().statusCode(200);

	}

	@Test
	public void testPatch() {

		JSONObject request = new JSONObject();

		request.put("name", "Krishna");
		request.put("job", "Test Lead");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("https://reqres.in/api/users").then().statusCode(200).log()
				.all();

	}

	@Test
	public void testDelete() {

		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	
	}

}
