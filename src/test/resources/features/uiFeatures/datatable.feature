Feature: Datatable for list webelement

  @UI
  Scenario: Datatable for list webelement
    Given user goes to test page
    When user clicks language flag button user verifies that texts are changing according to the language
      | ABD     | Finally |
      | Türkiye | Sonunda |
      | Almanya | Endlich |
      | Fransa  | Enfin   |
      | Rusya   | Наконец |
      | İspanya | Por fin |

  @UI
  Scenario: Datatable with list-map
    Given user login as therapist with email "test_trpst_basic@yopmail.com" password "Trpst13."
    And user clicks Services
    And user clicks Add New Individual Session Button
    * user remaines inputs empty and verifies alert message
      | name       | price | duration | blockBefore | blockAfter | warning                                                         |
      | individual | 256   |          | 5           | 60         | Please enter Duration                                           |
      |            | 256   | 1        | 5           | 60         | Please enter Form Name                                          |
      | individual |       | 1        | 5           | 60         | Please enter Price                                              |
      | individual | 256   | 1        |             | 60         | Enter the amount of Buffer Time required before the appointment |
      | individual | 256   | 1        | 5           |            | Enter the Buffer Time after the appointment                     |
      | individual | 256   | 1        | 5           | 60         | individual already in use!                                      |

