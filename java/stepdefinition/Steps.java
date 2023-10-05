package stepdefinition;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {
	
	public static RequestSpecification input;
	public static Response response;
	public static String sys_ID;
	
	@Given("Set the endpoint")
	public void setEndpoint() {
	RestAssured.baseURI="https://dev63097.service-now.com/api/now/table/incident";
	}
	
	@And("Set the Auth")
	public void setAuth() {
	
		RestAssured.authentication=RestAssured.basic("admin", "XW2pY$Aj2zr!");
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


