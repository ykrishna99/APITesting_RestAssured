package demo;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC_01 {

	// @Test
	public void test_01() {

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

	// @Test
	public void test_02() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(9));
	}

	/****** Part-2 ******/

	// @Test
	void test_03() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	}

	// @Test
	void test_04() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.first_name",
				hasItems("Michael", "Lindsay"));
	}

	// @Test
	void test_05() {

		given().param("key", "value").header("key", "value").when().get("https://reqres.in/api/users?page=2").then()
				.statusCode(200).body("data.first_name", hasItems("Michael", "Lindsay"));
	}

	// @Test
	void test_06() {

		given().get("http://localhost:3000/user/1").then().statusCode(200).log().all();
	}

	@Test
	public void test_post() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put("name", "Krishna");
		jsonMap.put("job", "Test Lead");

		JSONObject request = new JSONObject(jsonMap);
		System.out.println("JSON request is : " + request);

		// JSONObject request = new JSONObject();

		request.put("name", "Krishna");
		request.put("job", "Test Lead");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).

				when().post("https://reqres.in/api/users").then().statusCode(201);
		// body("", hasItems("Krishna"));
	}

	// @Test
	public void test_put() {

		JSONObject request = new JSONObject();

		request.put("name", "Krishna");
		request.put("job", "Test Lead");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).

				when().put("https://reqres.in/api/users/2").then().statusCode(200);
		// body("", hasItems("Krishna"));
	}

	// @Test
	public void test_patch() {

		JSONObject request = new JSONObject();

		request.put("name", "Krishna");
		request.put("job", "Test Lead");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).

				when().patch("https://reqres.in/api/users/2").then().statusCode(200);
		// body("", hasItems("Krishna"));
	}

	// @Test
	public void test_delete() {

		given().when().delete("https://reqres.in/api/users/2").then().statusCode(204);
		// body("", hasItems("Krishna"));
	}

	/****** Part-2 ******/

}
