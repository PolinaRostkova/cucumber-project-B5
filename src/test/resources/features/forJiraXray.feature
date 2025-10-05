@B5G3-108
Feature: Demo Auto-upload Json report to Xray


  @xrayJira @B5G3-144 @B5G3-147
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters username for client
    Then user enters password for client
    And user clicks login button
    Then user should be able to see the home page for client