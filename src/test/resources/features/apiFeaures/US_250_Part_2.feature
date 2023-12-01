Feature: US 250 part2
  Scenario: US-250/2 add location
    When user sends a request for adding a locationTwo
    Then user verifies success is true
    And user verifies that response is as expected for add locationTwo
    When user sends a request for deleting added locationTwo

  Scenario: US-251/2 get location
    When user sends a request for adding a locationTwo
    And user sends a request for getting all locationTwo
    And user verifies that response is as expected for get locationTwo
    When user sends a request for deleting added locationTwo

  Scenario: US-252/2 update location
    When user sends a request for adding a locationTwo
    And user sends a request for updating added locationTwo
    Then user verifies success is true
    And user verifies that response is as expected for update locationTwo
    When user sends a request for deleting added locationTwo

  Scenario: US-253/2 delete location
    When user sends a request for adding a locationTwo
    And user sends a request for deleting added locationTwo
    Then user verifies success is true
