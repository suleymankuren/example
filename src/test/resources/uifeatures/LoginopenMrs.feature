Feature: Open Mrs login test

  @smoke @regression @positiveLogin
  Scenario: Positive test to sign in Open Mrs
    When User navigates to open Mrs home page
    And User logs in with username and password
    Then User is logged in correctly