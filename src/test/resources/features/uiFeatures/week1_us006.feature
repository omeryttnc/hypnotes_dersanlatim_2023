Feature: week 1
  @UI
  Scenario: US 006
    Given user goes to test page
    Then assert first title color should be white
    And assert first title background color is green
    When user scroll to first title
    Then assert first title color should be black
    And assert first title background color is grey
