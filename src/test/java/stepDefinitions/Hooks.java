package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks 
{

	@Before("@GetPlace")
	public void beforeGetPlace() throws IOException
	{
		
		stepDefinitions sd= new stepDefinitions();
		if(stepDefinitions.getPlaceID==null)
		{
		sd.json_payload_with("Rajesh", "USA", "Espanol");
		sd.method_for_is_executed_with_the_provided_json_payload("Post", "addPlaceApi");
		}
		
	}
	
	
	@Before("@DeletePlace")
	public void beforeDeletePlace() throws IOException
	{
		if(stepDefinitions.getPlaceID==null)
		{
		stepDefinitions sd= new stepDefinitions();
		sd.json_payload_with("Rajesh", "USA", "Espanol");
		sd.method_for_is_executed_with_the_provided_json_payload("Post", "addPlaceApi");
		sd.validate_the_place_details_provided_in_json_should_be_added_successfully_in_response();
		}
	}
}
