@regression Qui
Feature: Testing Purchase Functionalities

  Background: Signing in
    Given User navigates to "GUrU99App" application
    When user enters username "admin@indtek.com" and "admin" and clicks on login in button

  @MTB-61
  Scenario: Validating price functionality
    And user clicks on Payment Gateway Project tab
    And user clicks on BUY NOW button for 3 toys
    Then user validates price is $60 for 3 toys in new opened page