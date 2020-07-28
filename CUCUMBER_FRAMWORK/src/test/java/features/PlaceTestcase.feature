Feature: Check  4 API Google

Scenario: Add Place
Given User add body for "add" Place API
When User call "AddPlaceAPI" with "POST" method
And Check status code 200
And Check performance less than 4000 ms
Then Assert "status" text is "OK" 
And Get "place_id" 


Scenario:  get APT
Given User add query param for add getAPI
When User call "GetPlaceAPI" with "GET" method
And Check status code 200
And Check performance less than 4000 ms
#Then Check returned


Scenario:  update Place
Given User add body for "update" Place API
When User call "UpdatePlaceAPI" with "PUT" method
Then Assert "msg" text is "Address successfully updated"
And User add query param for add getAPI
And User call "GetPlaceAPI" with "GET" method
And Assert "address" text is "123 Thanh Xuan"

#Then Check returned


Scenario:  delete Place
Given User add body for "delete" Place API
When User call "DeletePlaceAPI" with "DELETE" method
And Check status code 200
And Check performance less than 4000 ms
Then Assert "status" text is "OK" 
Given User add body for "delete" Place API
When User call "DeletePlaceAPI" with "DELETE" method
And Assert "msg" text is "Delete operation failed, looks like the data doesn't exists"
And User add query param for add getAPI
And User call "GetPlaceAPI" with "GET" method
And Assert "msg" text is "Get operation failed, looks like place_id  doesn't exists"


