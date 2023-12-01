#
#faker dan firstName lastName ve email olsuturun ve variable lara assign edin
#bu bilgileri kullanarak UI dan kullanici olusturun
#daha sonra backend den butun kullanicilari cekin
#backend den cekmis oldugunuz kullanicilarda, sizin olusturmus oldugunuz email kullanan kullanici var mi
#bu kullanicinin firstName ve lastName i sizin faker dan olusturdugunuz isimlerle ayni mi
#daha sonra kullaniciyi UI dan silin
#ve tum kullanicilari tekrar backend den cekip, backend den de kullanicinin silinmis oldugunun assertionini yapin.

@therapist
  @UI
  Feature: Task7 group 1
    Background:
      Given refresh page
      And user clicks on Clients Page

    Scenario: Task 7 group 1 TC1
      And user click on Add New Client button
      And user adds a client from UI
      When user sends a request for getting all clients
      Then user verifies that added client is exist in response
      When user clicks on Clients Page
      And user deletes added client from UI

    Scenario: Task 7 group 1 TC2
      And user click on Add New Client button
      And user adds a client from UI
      When user clicks on Clients Page
      And user deletes added client from UI
      When user sends a request for getting all clients
      Then user verifies that deleted client is not exist in response





