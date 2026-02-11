Feature: To validate flikart application 

Background:
Given Launch the Flipkart aplication
When Close the popup
Then It should navigates to the home page

@tc001 @Regression @Parallelsafe
Scenario:to validate the search functionality 

Given  user enter the text in the search field
When Click te search buttion
Then It should navigates to the search result page and display the relavent details
And Select Minimum and Maximum amount
And Select the Brand
And Select the Ram
And Select Battery Capacity
Then It should display the Relevant result


@tc002 @Regression @NONParallelsafe
Scenario: To validate the fashion functionality
Given user to move the fashion link
When curser to move to the kids link
And move to girls dress and click
And click the price high to low link
Then it should display therelevant details and get the title

@tc003 @Regression @Parallelsafe 
Scenario Outline: To validate the search functionality with different values

Given user enter the "<searchtext>" in the search field
When click the search button
Then en it should navigates to the text page and display the correspding page

Examples:
|searchtext|
|Mobile|
|tv|
|speaker|
|shirt|

@tc004 @Regression @NONParallelsafe
Scenario:To validate upto addcart functionality

Given User can move to the login link
When User can click the flipkart pluse zone
And Mouse move to the Home&Furniture link 
And going to click the wall lamp
And scroll down the page and click one particular result 
And Enter delivery pincode and click the check link 
Then Pincode should be checked and display and verify the titles 

@tc005 @Regression @Parallelsafe
Scenario: To get the title and price from search 
Given Enter the search text in the text field
When Click the search icon
Then It should the search result and get the title



@tc006 @Regression @Parallelsafe
 Scenario: To Test the search functionality with excel sheet 
Given Enter search Test in the search Field
When  click search Icon
Then It should display the Relevent result



 
 

