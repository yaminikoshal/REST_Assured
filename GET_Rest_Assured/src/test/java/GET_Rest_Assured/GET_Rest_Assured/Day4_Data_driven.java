package GET_Rest_Assured.GET_Rest_Assured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day4_Data_driven  extends BaseClassRestAssured{
	
//	@DataProvider(name="DataForPost")
//	public Object[][] dataForPost1Method() {
//		
//		Object[][] data= new Object[2][3];
//		data[0][0] = "saranya";
//		data[0][1] = "Ravi";
//		data[0][2] = 2;
//		data[1][0] = "sindhu";
//		data[1][1] = "sathish";
//		data[1][2] = 3;
//	
//		return data;
//	
//
//	}

//	@DataProvider(name="DataForPost")
	public Object[][] dataForPost2Method() {
		return new Object [] [] {
			{"Vani","raj",3},
			{"mohan","swathi",6},
			{"poorni","karthi",7},
			{"vel","smithi",9}
		};
		
	}
	
	@DataProvider(name="deleteData")
	public Object[] dataForDelete() {
		return new Object[] {
				4
		};
	}


}
