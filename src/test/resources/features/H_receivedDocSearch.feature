Feature: Received Docs filters with no matching results


  Background:
    Given user is on Docuport login page
    When user inserts "b1g2_client@gmail.com" to "username" field on "Login" page
    And user inserts "Group2" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "Choose account" page
    And user clicks "Received Doc" button on "Left Navigate" page
    And user clicks "Search" button on "Received doc" page
  @receivedPageSearch
  Scenario: Tag + Upload date + Uploaded by yields no results
    And user clicks "Tags" button on "Received doc" page
    And user clicks "Other documents" option on "Tags" dropdown
    And user clicks "IRS State Letter" option on "Tags" dropdown
    And user clicks "Upload date" button on "Received doc" page 
    And user clicks "9-6-25" option on "Upload date" dropdown
    And user clicks "Uploaded by" button on "Received Doc" page
    And user clicks "advisor advisor" option on "Uploaded by" dropdown
    And user clicks "Search submit" button on "Received doc" page
    Then user should see message "Your search returned no results. Make sure you search properly" on "Received Doc" page