Feature: week 2
  @UI
  Scenario: us 039
    When user goes to test page
    Then user should be able to see "Real People, Real Feedback"

    When user click on next button
    Then assert testimonials has changed


