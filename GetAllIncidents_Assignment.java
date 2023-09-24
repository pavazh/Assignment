package week3day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidents_Assignment {
	@Test
	public void GetAll() {
		Map<String,String> queryparams=new HashMap<String,String>();
		queryparams.put("sysparam_fields", "short_description,sys_id");
		queryparams.put("sysparam_limit", "10");
		RestAssured.baseURI="https://dev63097.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "XW2pY$Aj2zr!");
		RequestSpecification input=RestAssured.given().queryParams(queryparams);
		Response response=input.get();
		response.prettyPrint();
		
	}

}
