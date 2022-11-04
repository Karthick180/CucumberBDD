Feature: Test login functionality
  Scenario Outline: Check login is successful with valid credentials
    Given browser is launched
    And user is on login page
    When user enters <username> and <password>
    And user click login button
    Then user is navigated to home page

    Examples:
    |username|password|
    |Karthick|12345   |