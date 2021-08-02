Feature: Login APP Tests

  Scenario: Login in the App with an exists user
    Given open the app
    When enter the user "john.doe@gmail.com"
    And enter the password "JohnDoePass"
    And click the sign in button
    Then the name "john.doe@gmail.com" is in the screen


  Scenario: Fail login with incomplete password
    Given open the app
    When enter the user "john.doe@gmail.com"
    And enter the password "john"
    Then the sign in button is disabled
