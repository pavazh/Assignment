package steps;


import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import hooks.SetUp;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class IncidentManagement extends Common{
	
	

	public static RequestSpecification input;
	public static Response response;
	public static String sys_ID;
	
	@Given("Set the endpoint")
	public void setEndpoint() {
	RestAssured.baseURI="https://dev90367.service-now.com/api/now/table/incident";
	}
	
	@And("Set the Auth")
	public void setAuth() {
	
		RestAssured.authentication=RestAssured.basic("admin", "Nxxro1OKD@@4");
	}
	@When("Create incident with string body {string}")
	public void createIncident(String body) {
		
		input=RestAssured.given()
		.contentType("application/json").body(body);
	    response=input.post();
	    sys_ID=response.jsonPath().get("result.sys_id");
	}   
	
	@When("get Incidents")
	public void getIncident() {
		response=RestAssured.get();
		
	}
	@When("create incident with file {string}")
	public void createIncidentFile(String fileName) {
		File file=new File("./src/test/resources/"+fileName);
		input=RestAssured.given()
				.contentType("application/json").body(file);
			    response=input.post();
	}
	
	@When("Update Incident {string}")
	public void updateIncident(String body) {
		input=RestAssured.given()
		.contentType("application/json").body(body);
			    response=input.put("/"+sys_ID);
		
	}
	@When("Delete Incident")
	public void deleteIncident() {
		
		response=RestAssured.delete("/"+sys_ID);
	}
	
	@Then("Validate response code as {int}")
	    public void validateResponseCode(int statusCode) {
		
		response.then().assertThat()
		.statusCode(statusCode);
	    	
	    }
	
}


