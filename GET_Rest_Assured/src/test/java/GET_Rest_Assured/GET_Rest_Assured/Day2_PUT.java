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

public class Day2_PUT {

		
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
				.put("https://reqres.in/api/users/2")
			.then()
				.statusCode(200);

		}

	}

