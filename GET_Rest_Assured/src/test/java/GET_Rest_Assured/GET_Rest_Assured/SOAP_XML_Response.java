 package GET_Rest_Assured.GET_Rest_Assured;

import org.apache.poi.util.IOUtils;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SOAP_XML_Response {
	
	@Test
	public void validate_SOAP_XML_Res() throws IOException {
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
			.body("//*:addResult.text()", equalTo("3"));
 
	}

}
