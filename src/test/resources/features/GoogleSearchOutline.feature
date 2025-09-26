Feature: Scenario Outline Practice

  @google_search_outline @smoke
  Scenario Outline: scenario outline
    Given user is on Google page
    When user search for "<country>"
    Then user should see the capital "<capital>" in the results as capital
    And we love Loop Academy
    Examples:
      | country     | capital          |
      | Azerbaijan  | Baku             |
      | Ukraine     | Kyiv             |
      | Afghanistan | Kabul            |
      | USA         | Washington, D.C. |
      | Turkiye     | Ankara           |
      | Uzbekistan  | Tashkent         |
      | Georgia     | Tbilisi          |




