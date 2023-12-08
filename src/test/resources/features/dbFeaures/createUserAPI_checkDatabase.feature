Feature: API Database

  @DB
  Scenario: Create user from API and check if exist in database
    When we create user from API
    Then we need to check user exist in database