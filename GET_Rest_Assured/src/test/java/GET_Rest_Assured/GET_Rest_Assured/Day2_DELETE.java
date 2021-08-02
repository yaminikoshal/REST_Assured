package GET_Rest_Assured.GET_Rest_Assured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Day2_DELETE {
	
	@Test 
	public void test_01() {
	
		given()
		.when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log()
			.all();

	}


}
