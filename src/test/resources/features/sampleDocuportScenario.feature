@B5G3-149
Feature: Sample Docuport scenario

  @sampleDocuport @B5G3-150
  Scenario: Practice click button on different pages as a client
    Given user is on Docuport login page
    When user inserts "b1g1_client@gmail.com" to "username" field on "Login" page
    And user inserts "Group1" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "choose account" page
    Then user should be able to see the home page for client
    And user clicks "Invitations" button on "left navigate" page
    And user clicks "My uploads" button on "left navigate" page
    And user clicks "Received doc" button on "left navigate" page
    And user clicks "Search" button on "Received doc" page
    And user inserts "tax document" to "document name" field on "received doc" page
    And user clicks "My uploads" button on "left navigate" page
    And user clicks "Upload Documents" button on "My uploads" page
    #if input from html works then we dont need below step
    #And user clicks "Cancel" button on "My uploads" page
    And user clicks "Upload file" button on "My uploads" page
    And user uploads a document
