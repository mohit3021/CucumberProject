@token
Feature: Test all Smoke Scenarios for Token API
   Scenario: Test API Token with valid Credentials
   When Enter Vaild Application and request API
   Then Verify Status Code
   Then Verify Content Type
   Then Verify Response body
   Then Verify Generated jwt token