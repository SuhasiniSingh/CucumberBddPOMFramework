Feature: Account Page Feature

Background:
Given user has already logged into an application
|username|password|
|crochet2usa@gmail.com|selenium@2021|

Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Accounts section counts
Given user is on Accounts page
Then user gets Accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6

