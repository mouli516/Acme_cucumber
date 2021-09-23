Feature: Actitime Login page

Scenario Outline:  Actitme login with Valid credentials 
Given User Opened the Chrome browser
And Chrome browser is opened
And user is in Actitime login page
When user enters <username> and <password>in login and password textfields
And user click on LoginButon
Then Login page should be displayed

Examples: 
|username| password |
|admin   |  manager |
