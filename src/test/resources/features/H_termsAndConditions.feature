@B5G3-149
Feature: Terms & Conditions — new tab behavior

  Background:
    Given user is on Docuport login page
    When user inserts "b1g1_client@gmail.com" to "username" field on "Login" page
    And user inserts "Group1" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "Choose account" page

    @termsConditions @B5G3-154
  Scenario: New tab opens with correct heading
    When user clicks "Terms and conditions" button on "Left Navigate" page
    Then a new tab should open with heading "SERVICE TERMS AND CONDITIONS"