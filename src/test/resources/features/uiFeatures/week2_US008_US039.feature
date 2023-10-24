Feature: week 2

  Rule: US 039
    Background: prepare for us 39
      Given user goes to login page
      And user sends password "12ASDasd.,asdASD34"

    @UI
    Scenario: US 039 invalid
      When user sends invalid emails and check if user gets proper warning
        | therapist2023     | Please include an '@' in the email address. 'therapist2023' is missing an '@'. |
        | thera             | Please include an '@' in the email address. 'thera' is missing an '@'.         |
        | therapiapist2023@ | Please enter a part following '@'. 'therapiapist2023@' is incomplete.          |
        | therapiastr@      | Please enter a part following '@'. 'therapiastr@' is incomplete.               |

    @UI
    Scenario: US 039 valid
      And user sends email as "therapist2023@mailsac.com"
      When user clicks on login button
      Then user should be able to see "Login successfully" as alert message

