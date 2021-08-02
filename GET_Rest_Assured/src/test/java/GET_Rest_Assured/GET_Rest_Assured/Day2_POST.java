package GET_Rest_Assured.GET_Rest_Assured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.path.json.mapper.factory.GsonObjectMapperFactory;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Day2_POST {
	
	@Test //With map
	public void test_01() {
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("name", "yamini");
		map.put("job", "Tester");
		
		System.out.println(map);
		
		JSONObject request= new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());

	}
	
	@Test //WithOut Map
	public void test_02() {
		
		
		JSONObject request= new JSONObject();
		request.put("name", "yamini");
		request.put("job", "Tester");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
			.header("content-type","application/json")
			.body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);

	}

}
