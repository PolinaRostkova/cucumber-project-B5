@B5G3-149
Feature: My invitations — recipient search with no results

  Background:
    Given user is on Docuport login page
    When user inserts "b1g1_client@gmail.com" to "username" field on "Login" page
    And user inserts "Group1" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "Choose account" page
    And user clicks "Invitations" button on "Left Navigate" page
    And user clicks "Search" button on "Invitations" page

    @myInvitations @B5G3-153
  Scenario: Recipient = "loop" with Sent filter returns no results
    When user inserts "loop" to "Recipient" field on "Invitations" page
    And user clicks "Sent" button on "Invitations" page
    And user clicks "Search submit" button on "Invitations" page
    Then user should see message "Your search returned no results. Make sure you search properly" on "Invitations" page