#   faker dan firstName lastName ve email olsuturun ve variable lara assign edin
#bu bilgileri kullanarak UI dan kullanici olusturun
#daha sonra backend den butun kullanicilari cekin
#backend den cekmis oldugunuz kullanicilarda, sizin olusturmus oldugunuz email kullanan kullanici var mi
#bu kullanicinin firstName ve lastName i sizin faker dan olusturdugunuz isimlerle ayni mi
#daha sonra kullaniciyi UI dan silin
#ve tum kullanicilari tekrar backend den cekip, backend den de kullanicinin silinmis oldugunun assertionini yapin.
#simdiden herkese kolay gelsin

@UI
@therapist
  Feature: task 7
    Background:
      Given refresh page

    Scenario: Task 7 add client
      Given user adds a client from UI
      When user sends a request for getting all clients
      Then user verifies that created client is exist in response
      And user deletes added client from UI

    Scenario: Task 7 delete client
      Given user adds a client from UI
      And user deletes added client from UI
      When user sends a request for getting all clients
      Then user verifies that deleted client is not exist in response
