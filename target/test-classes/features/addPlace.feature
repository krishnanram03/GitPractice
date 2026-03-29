Feature: Verify add place API functionsality working

@Regression
@AddPlace
Scenario Outline: Validate Add place API working
Given Json Payload with "<name>" "<address>" "<language>"
When "Post" method for "addPlaceApi" is executed with the provided json payload
Then Validate status response code should be 200
And Validate the place details provided in json should be added successfully in response

Examples: 
|name |address|language|
|Ram  |RGV    |TN      |
#|Enoch|TGV    |FR      |

@Regression
@GetPlace
Scenario: Validate Get place API working
When "Get" method for "getPlaceApi" is executed with the provided json payload
Then Validate status response code should be 200


@Regression
@DeletePlace
Scenario: Validate Delete place API working
When "Delete" method for "deletePlaceApi" is executed with the provided json payload
Then Validate status response code should be 200
And Validate the place details should be deleted successfully in response