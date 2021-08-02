package GET_Rest_Assured.GET_Rest_Assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class Day1_GET_Rest_Assured {
	
	@Test
	void test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
			
			System.out.println(response.asString());
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println(response.getHeader("content-type"));
			System.out.println(response.getTime());
				
			int statusCode = response.statusCode();
			Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void test_02() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8));

	}
	

}
