Feature: Check login function 
Scenario: Log in with correct user name and password
Given Open URL
When Input username ="0909092829"
When Input password ="jkkskkkls"
And click login button
Then Assert user goes to home page

Scenario Outline: Log in with correct user name and password
Given Open URL
When Input username ="<username>"
When Input password ="<pass>"
And click login button
Then Assert user goes to home page
Then Assert wrong message "<message>"

Examples:
|username |pass   |message|
|63434444 | tegsgs|shshssb|
|         | tegsgs|kmsksms|
|rfffff   |       |lamnsks|
 