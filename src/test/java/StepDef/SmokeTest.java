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
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class SmokeTest {
	
	Response r;
	String response;
	

	@When("^Enter Vaild Application and request API$")
	public void enter_Vaild_Application_and_request_API() throws Throwable {
		
		YamlReader reader = new YamlReader(new FileReader("Mapplication.yml"));
		Object object = reader.read();
		System.out.println(object);
		Map map = (Map)object;
		String pass=(String)map.get("password");
		System.out.println(pass);
		String user=(String)map.get("username");
		System.out.println(user);
		String baseurl=(String) map.get("baseURL");
		System.out.println(baseurl);
		String api=(String)map.get("Api");
		System.out.println(api);
		
	    
       RestAssured.baseURI  = baseurl;	
       r=RestAssured.given().contentType("application/json").body("{\"password\": \"Collaboration!\", \"username\": \"coolmohit3021@gmail.com\"}")
    	.when().post(api);
	}

	@Then("^Verify Status Code$")
	
	public void verify_Status_Code() throws Throwable {
	  
		int statuscode=r.getStatusCode();
    	Assert.assertEquals(statuscode, 200, "Mohit Assertion Failed");
    	System.out.println(statuscode);
    	
    
    
	}
	
	@Then("^Verify Content Type$")
	public void verify_Content_Type() throws Throwable {
		String contentType= r.getContentType();
    	System.out.println(contentType);
	}

	@Then("^Verify Response body$")
	public void verify_Response_body() throws Throwable {
		response = r.getBody().asString();
		System.out.println(response);
		  
	}

	@Then("^Verify Generated jwt token$")
	public void verify_Generated_jwt_token() throws Throwable {
		
		
		JsonPath jsonPath = new JsonPath(response);
    	String jwt=jsonPath.get("jwt");
    	System.out.println("mohit");
    	System.out.println("Here is JWT Token: "+jwt);
	    
	}

}
