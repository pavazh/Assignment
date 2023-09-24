package week3day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident {
	@Test
	public void delete() {
		RestAssured.baseURI="https://dev63097.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "XW2pY$Aj2zr!");
		Response response = RestAssured.delete("6800c7c04761311052d81cfe826d4363");
		System.out.println(response.getStatusCode());
		
	}
}
