Feature: passing multiple information to the same step

  @google_search_data_table
  Scenario: Searching Multiple Items
    Given user is on Google page
    Then user search the following items
      | loop academy         |
      | java                 |
      | selenium             |
      | sql                  |
      | taras                |
      | suidum               |
      | savlat               |
      | polina               |
      | we love loop academy |
    And we love Loop Academy