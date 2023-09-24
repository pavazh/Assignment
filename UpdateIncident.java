package week3day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {
	@Test
	public void update() {
		RestAssured.baseURI="https://dev63097.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "XW2pY$Aj2zr!");
		RequestSpecification input=RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\": \"new System issue\",\r\n"
				+ "    \"short_description\": \"win\"\r\n"
				+ "}");
		Response response = input.put("6800c7c04761311052d81cfe826d4363");
		response.prettyPrint();
		
	}
}
