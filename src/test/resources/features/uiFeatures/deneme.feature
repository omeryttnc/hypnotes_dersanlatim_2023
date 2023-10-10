Feature: Login


#  Rule: bullet point 1 test
#    Background: goto test sayfasina gidecegiz
#      Given user goes to test page
#
#  Rule: bullet point 2 canli
#    Background: goto test sayfasina gidecegiz
#     Given user goes to production page
#
#  Rule: bullet point 3 deneme
#    @UI
#    @smoke
#    @login
  Scenario: is user able to login version 1
    Given Step Definition icinde user and password

#    @UI
#    @firefox
  Scenario: is user able to login version 2
    Given Configuration properties kullanarak


#    @UI
#    @smoke
#    @login
#    @headless
  Scenario: is user able to login version 3
    Given Scenariom icinde string olarak "user1"
    Given Scenariom icinde int olarak 3
    Given Scenariom icinde double olarak 4.6
    Given Scenariom icinde boolean olarak "false"
    Given Scenariom icinde genel olarak "user1" , 3 , 4.6 ve "false"

#    @smoke
#    @login
  Scenario: is user able to login version 4
    Given Data table kullanarak
      | user1 | password1 |
      | user2 | password2 |
      | user3 | password3 |
      | user4 | password4 |
    Then bir basamak daha olsa datalar icin
      | navbar        | title    |
      | Best Sellers  | keloglan |
      | Gift Ideas    |          |
      | Today`s Deals |          |
      | Music         |          |
      | Prime Video   |          |
      | New Releases  |          |
      | Prime         |          |
      | Toys & Games  |          |


  Scenario Outline: is user able to login version 5
    Given Scenariom Outline "<urunAdi>" and <rakam> <kusurat> "<dogru>"
    Then bir basamak daha olsa <rakam>
    Examples: scenario outline icin degerlerimiz
      | urunAdi                                                      | rakam | kusurat | dogru |
      | Skinsheen Bronzer Stick                                      | 1     | 88.50   | true  |
      | Total Moisture Facial Cream                                  | 2     | 76.00   | false |
      | Absolute Anti-Age Spot Replenishing Unifying TreatmentSPF 15 | 5     | 210.00  | true  |
      | Benefit Bella Bamba                                          | 2     | 56.00   | false |


  @user1
    @UI
    @omer
    @smoke
    @headless
  @firefox
#    @login
  Scenario: is user able to login version 6
    Given tag kullanarak


  @iPhone12
#    @DB
  Scenario: is user able to login version 7
    Given Enum kullanarak3


