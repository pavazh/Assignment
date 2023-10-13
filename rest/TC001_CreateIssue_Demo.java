package tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC001_CreateIssue_Demo extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new issue with Rest Assured";
		testDescription = "Create a new issue and Verify response Code";
		nodes = "Issue";
		authors = "Pavazh";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void createIssue(File file) throws FileNotFoundException, IOException {		
		
	/*	Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		String pathParam = prop.getProperty("incident_PP");
		prop.load(new FileInputStream(new File("./src/test/resources/response.properties")));
		String statusCode = prop.getProperty("responsecodeforPost");
		int responseCode = Integer.parseInt(statusCode);
		Response response = postWithBodyAsFileAndUrl(file, pathParam);
		verifyResponseCode(response, responseCode); */
		
		
		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().incident());
		verifyResponseCode(response,ConfigurationManager.configuration().responsecodeforPost());
        issueId = response.jsonPath().get("id");
	}


}




















