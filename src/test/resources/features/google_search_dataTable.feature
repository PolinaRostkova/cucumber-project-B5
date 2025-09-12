Feature: passing multiple information to the same step

  @google_search_data_table
  Scenario: Searching Multiple Items
    Given user is on Google page
    Then user search the following items
      | items        |
      | loop academy |
      | java         |
      | selenium     |
      | sql          |
      | taras        |
      | suidum       |
      | savlat       |
      | polina       |
    And we love Loop Academy