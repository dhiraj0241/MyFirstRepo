Feature: neostox login

Scenario: Verify that user should be able to login with valid credentials
Given User open the browser
And User launch portal of neostoc with URL "https://neostox.com/"
When User click on the signIn button on Homepage 
And User add the phone number as "8862071140" & click on signIn button
And User add the password as "1234" & click on signIn button
And capture the pagetitle of dashboard page
And click on the logout button
