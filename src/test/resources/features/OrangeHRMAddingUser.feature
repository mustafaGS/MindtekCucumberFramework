Feature: OrangeHRM adding user functionality

  Scenario: Adding user/employee functionality

    Given user navigates to "OrangeHRM" application
    When user enters username "Admin" and password "admin123" and clicks on login button
    And user clicks on PIM tab and user clicks on add employee
    And user enters new employee information and clicks save
    And user clicks on admin tab and creates username and password for employee and clicks save
    And user searches for newly created user and manages users information
    And validate new user information was edited
    Then user deletes newly created user and validates delete message