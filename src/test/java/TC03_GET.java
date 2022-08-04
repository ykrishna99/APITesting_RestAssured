import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TC03_GET {

	@Test
	void test01() {

		get("https://reqres.in/api/users?page=2").body().asString();

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);

	}
}
