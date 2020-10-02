Feature: Sport Search

@smoke
Scenario: Search bar functionality

Given I open a browser
When I navigate to www.google.com
And I search Soccer ball
Then I expect to see the ball result



@tag
Scenario Outline: Submit button functionality
Given I open a browser
When I navigate to www.google.com
And I search "<items>" in the Search
And I submit the search button
Then I expect search results "<expected>"

Examples:
|items|expected|
|ball|ball - Google Search|
|Physics||Physics - Google Search|
|Data|Data - Google Search|

