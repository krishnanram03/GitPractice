package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import Resources.EnumConst;
import Resources.Payloads;
import Resources.ReqRespBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class stepDefinitions extends ReqRespBuilder
{
	RequestSpecification reque,reque1;
	Response response;
	Payloads payload=new Payloads();
	String result;
	public static String getPlaceID;
	JsonPath js;
	
	@Given("Json Payload with {string} {string} {string}")
	public void json_payload_with(String name, String address, String language) throws IOException 
	{
	    // "reque" is just using the data provided to create payload and add the same to request specification builder
		reque=given().spec(setBaseSpec()).body(payload.addPlacePayload(name,address,language));
	}
	
	
	@When("{string} method for {string} is executed with the provided json payload")
	public void method_for_is_executed_with_the_provided_json_payload(String method, String apideets) throws IOException
	{
		//EnumConst uses enum class to dynamically call the method and as well as the resource parameter to be utilized as per the call in feature file
		//"response" object actually performs the execution of the API call as per the enum class resource parameter and stores the response in the object
		reque1=given().spec(setBaseSpec());
		EnumConst es=EnumConst.valueOf(apideets);
		if(method.equalsIgnoreCase("Post"))
		{
		
		response=reque.when().post(es.getLink()).then().spec(setResponseSpec()).extract().response();
		result=response.asString();
		js= new JsonPath(result);
		getPlaceID=js.get("place_id");
		}
		else if(method.equalsIgnoreCase("Get"))
		{
		
			response=reque1.queryParam("place_id",payload.getPlacePayload(getPlaceID)).get(es.getLink()).then().spec(setResponseSpec()).extract().response();
			result=response.asString();
			js= new JsonPath(result);
		}
		else if(method.equalsIgnoreCase("Delete"))
		{
			response=reque1.body(payload.deletePlacePayload(getPlaceID)).post(es.getLink()).then().spec(setResponseSpec()).extract().response();
		
			
		}
	}
	
	
	@Then("Validate status response code should be {int}")
	public void validate_status_response_code_should_be(Integer int1) 
	{
		//asserting that the api returns the 200 status code
		
		assertEquals(response.getStatusCode(),200);
		
	}
	
	
	@And("Validate the place details provided in json should be added successfully in response")
	public void validate_the_place_details_provided_in_json_should_be_added_successfully_in_response() 
	{
		
		js.getString("status").equalsIgnoreCase("OK");
	}

	
	@And("Validate the place details should be deleted successfully in response")
	public void validate_the_place_details_should_be_deleted_successfully_in_response() 
	{
		result=response.asString();
		js= new JsonPath(result);
		js.get("status").toString().equalsIgnoreCase("OK");
	}




}

