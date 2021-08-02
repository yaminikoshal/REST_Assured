package GET_Rest_Assured.GET_Rest_Assured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Day2_PATCH {
	
	@Test 
	public void test_01() {
		
		
		JSONObject request= new JSONObject();
		
		request.put("name", "yamini");
		request.put("job", "Tester");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
			.header("content-type","application/json")
			.body(request.toJSONString())
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log()
			.all();

	}

}
