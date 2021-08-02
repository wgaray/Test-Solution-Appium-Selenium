Feature: Search tests

Feature Description

  Scenario: Search tv show and access url
    Given open browser
    When search the tv show "batman"
    And click the second URL
    And go back with browser features
    And change background color
    And click the back button
    Then the url is the same
    And the input search is empty
