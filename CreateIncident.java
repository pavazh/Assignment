package week3day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {
	@Test
	public void create() {
		RestAssured.baseURI="https://dev63097.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "XW2pY$Aj2zr!");
		RequestSpecification input=RestAssured.given().contentType("application/json").accept("application/json").when().body("{\r\n"
				+ "    \"description\": \"Laptop is not working\",\r\n"
				+ "    \"short_description\": \"windows\"\r\n"
				+ "}");
		
		Response response = input.post();
		String sysid=response.jsonPath().get("result.sys_id");
		System.out.println("the extracted sysid is "+sysid);
		int statuscode=response.getStatusCode();
		System.out.println("My Status code is "+statuscode);
		response.prettyPrint();
	}

}
