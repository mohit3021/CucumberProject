package StepDef;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.testng.Assert;
import org.testng.internal.Yaml;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class NewSmokeTest {
	
	Response r;
	
		@Test
		public void enter_Vaild_Token_and_request_API()
		{
		    RestAssured.baseURI  = "https://stage-api.core.merrillcorp.com";
	
			r=RestAssured.given().
		    authentication().
		    oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTU4ZDU3NC1lNmYxLTQ1YWUtYjU2ZC04YThmOWFlZDc2YTQiLCJncm91cCI6ImNsaWVudCIsImV4cCI6MTUxMzY3OTgyOTU0Miwic2NvcGUiOltdLCJpc3MiOiJpYW0ubWVycmlsbGNvcnAuY29tIiwiYXVkIjoiamF2ZWxpbm1jLmNvbSIsIlVzZXJOYW1lIjoiYXNoaXNoLnNoYXJtYTZAZ2xvYmFsbG9naWMuY29tIn0.FMrc87lnG8CB81recc0OOSi0J4PTwTjnoO2bagIcjVg", OAuthSignature.HEADER).
		    contentType("application/json").body("{\r\n\"projectInfo\": {\r\n  \"active\": true,\r\n  \"datacenter\": \"Unique_DCenter_3\",\r\n  \"emailId\": \"dummyid86@gmail.com\",\r\n  \"projectDescription\": \"Mohit_1sharma_1project_details\",\r\n  \"projectName\": \"Mohit_Project11140fd3\",\r\n  \"projectType\": \"M1Type\",\r\n  \"salesforceProjectId\": \"mmSales_Force_14146111\"\r\n}\r\n\r\n}").
		    when().
            post("/api/projects");
            
			
			int sc=r.getStatusCode();
			
			System.out.println(sc);
			
			System.out.println("mohit sharma");
			
			String gb=r.getBody().asString();
			
			System.out.println(gb);
			
			System.out.println("mohit");
			
			
			
		
        
           
			
			
		
		}
		
}
