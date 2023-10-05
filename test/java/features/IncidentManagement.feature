Feature: Manage Incidents in Service Now

Background:
Given Set the endpoint
And Set the Auth

Scenario: Create Incident
When Create incident with string body '{"short_description":"service","description":"servicing desktop"}'
Then Validate response code as 201

Scenario: Create Incident with String
When Create incident with string body '{"short_description":"service makers","description":"servicing desktop"}'
Then Validate response code as 201

Scenario: Get All Icnidents
When get Incidents
Then Validate response code as 200

Scenario Outline: Create incident with Multiple File
When create incident with file '<fileName>'
Then Validate response code as 201
Examples:
|fileName|
|CreateIncident_1.json|
|CreateIncident_2.json|

Scenario: Update Incident
When Update Incident '{"short_description":"Update Short_description","description":"servicing desktop"}'
Then Validate response code as 200

Scenario: delete Incident
When Delete Incident
Then Validate response code as 204







