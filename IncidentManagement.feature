Feature: Manage Issues in Jira

Background:
Given Set the endpoint
And Set the Auth

Scenario Outline: Create Issue with Multiple File
When create Issue with file '<fileName>'
Then Validate response code as 201
Examples:
|fileName|
|incident1.json|
|incident2.json|

Scenario: Update Issue
When Update Issue '{"fields":{"description": "Bug creation Using REST API for testing"}}'
Then Validate response code as 204

Scenario: delete Issue
When Delete Issue
Then Validate response code as 204







