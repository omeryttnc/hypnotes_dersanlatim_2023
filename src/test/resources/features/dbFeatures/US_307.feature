@UI
@DB
  @therapist
  Feature: As a therapıst, when i should add new locatıon on your profıle
    then I Should be able to see added locatıon  in the correct  schema and columns in DB

  Scenario: US_307 TC_01
    Given refresh page
    And user deletes all locations
    When user creates a new location
    And user waits 2 second
    And user verifies added location is exist on related table
