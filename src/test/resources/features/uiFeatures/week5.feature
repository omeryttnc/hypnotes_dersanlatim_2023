Feature: week 6

  @UI
  @therapist
  Scenario: lambda kullanarak link lerin assertion
    Then assert side bar by lambda


  @UI
  @therapist
  Scenario: datatable kullanarak link lerin assertion 1
    Then assert side bar by datatable column
      | Dashboard      |
      | Calendar       |
      | Services       |
      | Clients        |
      | Documents      |
      | Coupons        |
      | Questionnaires |
      | Email & SMS    |
      | Settings       |

  @UI
  @therapist
  Scenario: datatable kullanarak link lerin assertion 2
    Then assert side bar by datatable map
      | navbar         | index |
      | Dashboard      | 0     |
      | Calendar       | 1     |
      | Services       | 2     |
      | Clients        | 3     |
      | Documents      | 4     |
      | Coupons        | 5     |
      | Questionnaires | 6     |
      | Email & SMS    | 7     |
      | Settings       | 8     |

    @UI
    @therapist
  Scenario Outline: scenario outline kullanarak link lerin assertion
    Then assert side bar by scenario outline "<sidebar>" <index>
    Examples: kullanilacak datalarim
      | sidebar        | index |
      | Dashboard      | 0     |
      | Calendar       | 1     |
      | Services       | 2     |
      | Clients        | 3     |
      | Documents      | 4     |
      | Coupons        | 5     |
      | Questionnaires | 6     |
      | Email & SMS    | 7     |
      | Settings       | 8     |


