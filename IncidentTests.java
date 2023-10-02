package services;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class IncidentTests extends BaseRequest{
	
	
@Test
	public void getIssue(){
	  RestAssured.given()
			.get("issue")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("id"))
			.extract().response();
				
	}
	
	@Test
	public void createIssue(){
		RestAssured.given()	.contentType("application/json").when()	
		.body(new File("./data/incident1.json"))
			.post("issue")
			.then()
			.assertThat()
			.statusCode(201)
			.body(containsString("id"));		
	}
	
	@Test
	public void updateIssue() {
		
		RestAssured.given()	.contentType("application/json").when()	
		.body(new File("./data/incident1.json"))
		.put("issue/c3c80d23977211105be87f5e6253af6d")
		.then()
		.assertThat()
		.statusCode(404);
		
	}
	
	public void deleteIssue() {
		RestAssured.given()	.contentType("application/json").when()	
		.body(new File("./data/incident1.json"))
		.delete("issue/c3c80d23977211105be87f5e6253af6d")
		.then()
		.assertThat()
		.statusCode(404);
	}
	
	
	
	@Test
	public void getAllIncidents() {
		
		RestAssured.given().queryParam("sysparm_fields", "id")
		.get("issue")
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	
}
