package StepDef;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.internal.Yaml;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class SmokeTest {
	
	Response r;
	String response;
	String jwt;
	

	
		
		@When("^Enter Vaild Token and request API$")
		public void enter_Vaild_Token_and_request_API() throws Throwable {
		
			/*String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzMDY5NzA0OC1kMDIyLTRhMjItYWFkMy04OWQ2YzY4ODJiOWMiLCJncm91cCI6ImNsaWVudCIsImV4cCI6MTUxMzI0NDU1NzYwNywic2NvcGUiOltdLCJpc3MiOiJpYW0ubWVycmlsbGNvcnAuY29tIiwiYXVkIjoiamF2ZWxpbm1jLmNvbSIsIlVzZXJOYW1lIjoiY29vbG1vaGl0MzAyMUBnbWFpbC5jb20ifQ.opT0-FgwrErJtsLQ4Li0LhCied1LfSL-f4XtwoSyn78";
	       RestAssured.baseURI  = "https://stage-web.core.merrillcorp.com";
	       r=(Response) RestAssured.given().contentType("application/json").header("authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MDQyMDczOC1kZmE3LTRiNGMtYTgxOC02MDExZGRkZjkwMmUiLCJncm91cCI6ImNsaWVudCIsImV4cCI6MTUxMzQwOTQ4ODYyOCwic2NvcGUiOltdLCJpc3MiOiJpYW0ubWVycmlsbGNvcnAuY29tIiwiYXVkIjoiamF2ZWxpbm1jLmNvbSIsIlVzZXJOYW1lIjoiZHVtbXlpZDZAZ21haWwuY29tIn0.1TcqtTPnPwLZYdksiaP5zUhOdoyISVdCBJlT_-GJ5tU");
	    		   
	    		   
	    
	       .formParam("active", true).formParam("datacenter", "string").formParam("emailId", "hello@gmail.com")
	       .formParam("projectDescription", "helloworld").formParam("projectName", "hellomohit").formParam("projectType", "jev")
	       .formParam("salesforceProjectId", "dghsdhfusdsb").when().post("/api/projects");
	       
	       OkHttpClient client = new OkHttpClient();

	       MediaType mediaType = MediaType.parse("application/json");
	       RequestBody body = RequestBody.create(mediaType, "{\r\n\"projectInfo\": {\r\n  \"active\": true,\r\n  \"datacenter\": \"Unique_DCenter_3\",\r\n  \"emailId\": \"dummyid6@gmail.com\",\r\n  \"projectDescription\": \"Mohit sharma project details\",\r\n  \"projectName\": \"Ashish Project140fd3\",\r\n  \"projectType\": \"M1Type\",\r\n  \"salesforceProjectId\": \"mSales_Force_14146\"\r\n}\r\n\r\n}");
	       Request request = new Request.Builder()
	         .url("https://stage-web.core.merrillcorp.com/api/projects")
	         .post(body)
	         .addHeader("authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MDQyMDczOC1kZmE3LTRiNGMtYTgxOC02MDExZGRkZjkwMmUiLCJncm91cCI6ImNsaWVudCIsImV4cCI6MTUxMzQwOTQ4ODYyOCwic2NvcGUiOltdLCJpc3MiOiJpYW0ubWVycmlsbGNvcnAuY29tIiwiYXVkIjoiamF2ZWxpbm1jLmNvbSIsIlVzZXJOYW1lIjoiZHVtbXlpZDZAZ21haWwuY29tIn0.1TcqtTPnPwLZYdksiaP5zUhOdoyISVdCBJlT_-GJ5tU")
	         .addHeader("content-type", "application/json")
	         .addHeader("cache-control", "no-cache")
	         .addHeader("postman-token", "3647c57c-02ec-a372-3e4b-dbed0ba6576e")
	         .build();

	       Response r = client.newCall(request).execute();
	       
	       
		}
	       
	       /*       r=RestAssured
	    		   .given()
	    		   .contentType("application/json").
	    		   body("{\"projectInfo\": {\"active\": true,\n" +
    "\"datacenter\": \"string\",\n"+
    "\"emailId\": \"ab1c123@gmail.com\",\n"+"\"projectDescription\": \"Hello1\",\n"+"\"projectName\": \"mohitproject\",\n"+
    "\"projectType\": \"jev1\",\n"+"\"salesforceProjectId\": \"mohit123mohit12ss\"\n"+"}}")
	    	.when().post("/api/projects");
	       
	       
	       
	       
	       
	       
	    // RestAssured.given().preemptive().auth().oauth2("Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzMDY5NzA0OC1kMDIyLTRhMjItYWFkMy04OWQ2YzY4ODJiOWMiLCJncm91cCI6ImNsaWVudCIsImV4cCI6MTUxMzE1OTk5Njg1MSwic2NvcGUiOltdLCJpc3MiOiJpYW0ubWVycmlsbGNvcnAuY29tIiwiYXVkIjoiamF2ZWxpbm1jLmNvbSIsIlVzZXJOYW1lIjoiY29vbG1vaGl0MzAyMUBnbWFpbC5jb20ifQ.Dr0R40JXRvnCBirU0z17ioW1rYNVRHepMis68EAiAFo");
		   
	     //RestAssured.given().auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzMDY5NzA0OC1kMDIyLTRhMjItYWFkMy04OWQ2YzY4ODJiOWMiLCJncm91cCI6ImNsaWVudCIsImV4cCI6MTUxMzE1OTk5Njg1MSwic2NvcGUiOltdLCJpc3MiOiJpYW0ubWVycmlsbGNvcnAuY29tIiwiYXVkIjoiamF2ZWxpbm1jLmNvbSIsIlVzZXJOYW1lIjoiY29vbG1vaGl0MzAyMUBnbWFpbC5jb20ifQ.Dr0R40JXRvnCBirU0z17ioW1rYNVRHepMis68EAiAFo");
		}
		
*/
		}
		@Then("^Verify Status CodeProj$")
		public void verify_Status_CodeProj() throws Throwable {
			int statuscode=r.getStatusCode();
			System.out.println(statuscode); 
			r.then().assertThat().statusCode(401);
			
	    	
		}

		@Then("^Verify Content TypeProj$")
		public void verify_Content_TypeProj() throws Throwable {
			System.out.println("content type");
		   
		}

		@Then("^Verify Response bodyProj$")
		public void verify_Response_bodyProj() throws Throwable {
			response = r.getBody().asString();
			System.out.println(response); 
		}
}

