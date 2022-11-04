Feature: launch google and search for result
  Scenario: validate the result is coming from the google
    Given browser is open
    And user is on google search page
    When user enters a text in search box
    And hits enter
    Then user is able to see the results
