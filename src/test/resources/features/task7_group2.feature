#faker dan firstName lastName ve email olsuturun ve variable lara assign edin
#bu bilgileri kullanarak UI dan kullanici olusturun
#daha sonra backend den butun kullanicilari cekin
#backend den cekmis oldugunuz kullanicilarda, sizin olusturmus oldugunuz email kullanan kullanici var mi
#bu kullanicinin firstName ve lastName i sizin faker dan olusturdugunuz isimlerle ayni mi
#daha sonra kullaniciyi UI dan silin
#ve tum kullanicilari tekrar backend den cekip, backend den de kullanicinin silinmis oldugunun assertionini yapin.

@therapist
  @UI
  Feature: Task 7 Group 2 TC1
    Background:
      Given refresh page
      When user clicks on Clients Page

    Scenario: Task 7 Group 2
      And user click on Add New Client button
      And user adds a client from UI two
      When user sends a request for getting all clients two
      Then user verifies that added client is exist in response two
      When user clicks on Clients Page
      And user deletes added client from UI two

    Scenario: Task 7 Group 2 TC2
      And user click on Add New Client button
      And user adds a client from UI two
      When user clicks on Clients Page
      And user deletes added client from UI two
      When user sends a request for getting all clients two
      Then user verifies that deleted client is not exist in response two


