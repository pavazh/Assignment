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
	public static String issueid;
	
	@Given("Set the endpoint")
	public void setEndpoint() {
	RestAssured.baseURI="https://pavazha-thamizh.atlassian.net/rest/api/2/issue";
	}
	
	@And("Set the Auth")
	public void setAuth() {
	
		RestAssured.authentication=RestAssured.preemptive().basic("pavazh@gmail.com", "ATATT3xFfGF00HjyiASzIM1DSMkE7o1By1qZuMtucDO6HmG1z5wGFefZff1VQgRNLqKD5chDJ5QTQDyU-b9pN6sDoGv377yrnIqHMVhg_F0KSwEO_iWw2EF6CfbnNzL5PL1UdnAKrq3qm-XvBnrR4ZbT6IEn3WufhD0IIBHc9H7czx4Q6An0rMk=A360A74A");
	}
	
	@When("create Issue with file {string}")
	public void createIssueFile(String fileName) {
		File file=new File("./src/test/resources/"+fileName);
		input=RestAssured.given()
				.contentType("application/json").body(file);
			    response=input.post();
			    issueid = response.jsonPath().get("id");
	}
	
	@When("Update Issue {string}")
	public void updateIssue(String body) {
		input=RestAssured.given()
		.contentType("application/json").body(body);
			    response=input.put("/"+issueid);
		
	}
	@When("Delete Issue")
	public void deleteIssue() {
		
		response=RestAssured.delete("/"+issueid);
	}
	
	@Then("Validate response code as {int}")
	    public void validateResponseCode(int statusCode) {
		
		response.then().assertThat()
		.statusCode(statusCode);
	    	
	    }
	
}


