Feature: googlesearch

Scenario Outline:  verify google search is working 
Given Browser is opened
And user is on google page
When user enters <name>in Searchfield
And user click on searchbutton
Then search results page should be displayed

Examples: 
|name|
|mouli nadipena|


 


