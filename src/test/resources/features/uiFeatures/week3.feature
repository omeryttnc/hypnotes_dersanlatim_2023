Feature: week3

  @UI
  @therapist
  Scenario: create user
#    Given user login as therapist
    And refresh page
    And user clicks on Clients Page

    When user click on Add New Client button
    Then user should be able to see Add New Client form

    When user enter new client information's
    When user click on Yes button
#    Then user should be able to see "New Client is successfully added." as alert message

    When user clicks on Clients Page
    Then user should able to see created client

    When user click on delete button
    Then user should see "Warning: Deleting client data cannot be undone. All client and session data will be permanently erased. Are you sure you wish to delete?" caution message

    When user click on Yes button
#    Then user should be able to see "Client has been deleted" as alert message
    And assert user is deleted


