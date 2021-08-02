 package GET_Rest_Assured.GET_Rest_Assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;



public class Day3New_Example {
	
//	 @Test
	public void test_Get() {
		
		baseURI="http://localhost:3000/";
		
		given()
			.header("content-type","application/json")
			.param("name", "Automation")
			.get("/subjects")
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}
	
	@Test
	public void test_Post() {
		
		JSONObject request =new JSONObject();
		
		request.put("firstName", "xxx");
		request.put("lastName", "yyy");
		request.put("subjectId", 3);
//		request.put("name", "Tester");
		
		
	
		
		baseURI="http://localhost:3000/";
		
		given()
			.header("content-type","application/json")
			.body(request.toJSONString())
		.when()
			.post("/user")
			//.post("/subjects")
			
		.then()
			.statusCode(201)
			.log()
			.all();
	}
	
//	@Test
	public void test_Put() {
		
		JSONObject request =new JSONObject();
		
		request.put("firstName", "zzz");
		request.put("lastName", "AAA");
		request.put("subjectId", 3);
//		request.put("name", "Tester");
		
		baseURI="http://localhost:3000/";
		
		given()
			.header("content-type","application/json")
			.body(request.toJSONString())
		.when()
			.put("/user/4")
			//.post("/subjects")
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}
//	@Test
	public void test_Patch() {
		
		JSONObject request =new JSONObject();
		
		request.put("firstName", "zzz");
		request.put("lastName", "BBB");
		request.put("subjectId", 3);
		
//		request.put("name", "Tester");
		
		baseURI="http://localhost:3000/";
		
		given()
			.header("content-type","application/json")
			.body(request.toJSONString())
		.when()
			.patch("/user/4")
			//.post("/subjects")
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}
	@Test
	public void test_Delete() {
		

		baseURI="http://localhost:3000/";
		
			
		when()
			.delete("/subjects/1")
			
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}
	
}
