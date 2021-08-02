package GET_Rest_Assured.GET_Rest_Assured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Day2_Test_Get {
	
	@Test
	public void test_01() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.body("data.first_name", hasItems("Michael","Lindsay"))
			.log()
			.all();
			
	}
	

}
