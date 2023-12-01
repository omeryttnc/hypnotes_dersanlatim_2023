Feature: US-250/251/252/253 Location requests
  Background: Location
    Given user sends a request for phpSessId

  Scenario: US-250 add location
    When user sends a request for adding a location
    Then user verifies success is true for location
    And user verifies that response is as expected for add location
    When user sends a request for deleting added location

    Scenario: US-251 get location
      When user sends a request for adding a location
      And user sends a request for geting all locations
      And user verifies that response is as expected for get location
      When user sends a request for deleting added location

  Scenario: US-252 update location
    When user sends a request for adding a location
    And user sends a request for updating added location
    Then user verifies success is true for location
    And user verifies that response is as expected for update location
    When user sends a request for deleting added location

  Scenario: US-253 delete location
    When user sends a request for adding a location
    And user sends a request for deleting added location
    Then user verifies success is true for location
