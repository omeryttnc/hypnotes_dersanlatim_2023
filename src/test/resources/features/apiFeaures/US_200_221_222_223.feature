Feature: Requrring Day Block Time create, update, get delete

  Background:
    Given user take token from api

  Scenario: Recurring Day Block Time create
    Then user creates a Recurring Block Time from api
    And user verifies status is true
    And user verifies that response is as expected



Scenario: Recurring Day Block Time get
  Then user gets all Recurring Block Times from api
  And user verifies created Block Time is exist in response


#  --------------- update requesti create e bakılarak yapılabilir--------------
#  Scenario:Recurring Day Block Time update
#    Then user updates a Recurring Block Time from api
#    And user verifies status is true
#    And user verifies that response is as expected



    Scenario: Recurring Day Block Time delete
      Then user deletes the recurring Block Time from api
      And user verifies status is true



  Scenario: Recurring Day Block Time get
    Then user gets all Recurring Block Times from api
    And user verifies deleted Block Time is not exist in response