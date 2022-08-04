import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TC02_GET {

	@Test
	void test_01() {
		baseURI = "https://reqres.in/api/users";

		get("?page=2").then().body("data.id[0]", equalTo(9));
	}

	@Test
	void test_02() {
		baseURI = "https://reqres.in/api/users";

		given().param("", "").header("", "").when().get("").then().statusCode(200);

		get("?page=2").then().body("data.id[0]", equalTo(9));
	}
}
