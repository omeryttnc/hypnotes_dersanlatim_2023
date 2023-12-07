#database deki butun clientleri donduren bir method olusturun. methodun return u List<CreatedClient> olacak sekilde ayarlayabilirsiniz

#bu listedeki Client lerin hepsinin id si oldugunun assertion i yapin

#email lerinin oldugunun (burada bug olabilir cunku bazi kullancilarin mailleri null yani bu test fail olacak)
#
# client tablsunda roles da ROLE_CLIENT_Verify var ise password olmalı yok ise null olduğunun assertionı

#created tarihlerinin bugunden eski oldugunun

#facebook google ve linkedin den kullanarak hesap acan kullanicilarin sayilarini bulur ve bu kullanicilarinin hepsinin roles lerinde ROLE_CLIENT_VERIFIED oldugunun assertion i yaparsiniz

# (eger bir kullanici mesela google kullanarak hesap actiysa google id si oluyor database de


  Feature: Assertion passwords, roles for all clients
    Background:
      Given user gets all created clients from db

    Scenario: TC_01 Assertion ids
      Then user verifies that all clients have id

    Scenario: TC_02 Assertion emails
      Then user verifies that all clients have email

    Scenario: TC_03 Assertion passwords, roles for all clients
      Then user verifies that there is password when ROLE_CLIENT_VERIFIED is exist for roles column

    Scenario: TC_04 Assertion created dates
      Then user verifies that created dates are before today

    Scenario: TC_05 Assertion passwords, roles for all clients
      Then user verifies that ROLE_CLIENT_VERIFIED is true when client sign up with, google, facebook or linkedin
