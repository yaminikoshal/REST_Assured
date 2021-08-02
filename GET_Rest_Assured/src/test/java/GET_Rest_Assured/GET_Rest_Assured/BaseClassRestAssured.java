package GET_Rest_Assured.GET_Rest_Assured;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClassRestAssured {
	
//	@Test(dataProvider="DataForPost")
	public void test_Post(String firstName,String lastName,int subjectId) {
		
		JSONObject request =new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		baseURI="http://localhost:3000/";
		
		given()
			.header("content-type","application/json")
			.body(request.toJSONString())
		.when()
			.post("/user")
			
		.then()
			.statusCode(201)
			.log()
			.all();
	}
	
//	@Test(dataProvider = "deleteData")
	public void test_Delete(int userId) {
		
		baseURI="http://localhost:3000/";
		
			
		when()
			.delete("/user/"+userId)
			
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}
	
	@Parameters({"userId"})
	@Test
	public void test_Delete2parameter(int userId) {
		System.out.println("value for userId is :" +userId);
		baseURI="http://localhost:3000/";
		
			
		when()
			.delete("/user/"+userId)
			
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}

}
