package GET_Rest_Assured.GET_Rest_Assured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class Day6_XML_Schema_Validation {
	
	@Test
	public void test_01() throws IOException {
		File file = new File("./SOAP/Add.xml");
		if(file.exists())
			System.out.println("File Exits");
		
		FileInputStream f= new FileInputStream(file);
		String requestBody=org.apache.commons.io.IOUtils.toString(f,"UTF-8");
		
		baseURI="http://www.dneonline.com/";
		
		given()
			.header("content-type","text/xml")
			.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("/calculator.asmx ")
		.then()
			.statusCode(200)
			.log()
			.all()
		.and()
			.body("//*:addResult.text()", equalTo("3"))
		.and()
			.assertThat()
			.body(matchesXsdInClasspath("calculator.xsd"));
 

	}

}
