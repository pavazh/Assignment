package tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC001_CreateIssue_NegativeTestcase extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Incident with Rest Assured";
		testDescription = "Create a new Incident and Verify response Code";
		nodes = "Incident";
		authors = "Shan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {
		//for reports		
		svcTest = startTestModule(nodes);
		svcTest.assignAuthor(authors);
		svcTest.assignCategory(category);
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		
		RestAssured.baseURI = "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/";
		RestAssured.authentication = RestAssured.basic(prop.getProperty("username"), "test123");
		
		
			
	

	}

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) throws FileNotFoundException, IOException {		

		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().incident());
		verifyResponseCode(response, ConfigurationManager.configuration().unAuthorizedUser());
		response.prettyPrint();

	}


}




















