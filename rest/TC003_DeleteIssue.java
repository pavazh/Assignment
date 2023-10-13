package tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import freemarker.template.Configuration;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC003_DeleteIssue extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Delete Issue with Rest Assured";
		testDescription = "Delete Issue and Verify response Code";
		nodes = "Issue";
		authors = "Pavazh";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dependsOnMethods = "tests.rest.TC001_CreateIssue_Demo.createIssue")
	public void DeleteIncident() throws FileNotFoundException, IOException {		
		
             
	Response response = delete(ConfigurationManager.configuration().incident()+"/"+issueId);
    verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforDelete());
	}

	


}




















