Feature: Register
Scenario: Register with correct user name and password
Given Register
When Register username ="0909092829"
When Register password ="jkkskkkls"
And click register button
Then Assert user goes to home page