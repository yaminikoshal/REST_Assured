package GET_Rest_Assured.GET_Rest_Assured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class JSON_Schema_Validation {
	
	@Test
	public void test_Get() {
		
		baseURI="https://reqres.in/api";
		
		given()
			.header("content-type","application/json")
			.get("/users?page=2")
			
		.then()
			.assertThat()
			.body(matchesJsonSchemaInClasspath("schema.json")) 
			.statusCode(200)
			.log()
			.all();
	}

}
