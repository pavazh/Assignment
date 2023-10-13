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


public class TC002_UpdateIssue extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update Issue with Rest Assured";
		testDescription = "Update Issue and Verify response Code";
		nodes = "Issue";
		authors = "Pavazh";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData",dependsOnMethods = "tests.rest.TC001_CreateIssue_Demo.createIssue")
	public void updateIssue(File file) throws FileNotFoundException, IOException {		
		
             
	Response response = putWithBodyParam(file,ConfigurationManager.configuration().incident()+"/"+issueId);
    verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPut());
	}


}




















