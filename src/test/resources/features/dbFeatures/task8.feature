#database deki butun clientleri donduren bir method olusturun. methodun return u List<CreatedClient> olacak sekilde ayarlayabilirsiniz

#bu listedeki Client lerin hepsinin id si oldugunun assertion i yapin

#email lerinin oldugunun (burada bug olabilir cunku bazi kullancilarin mailleri null yani bu test fail olacak)

  #client tablsunda roles da ROLE_CLIENT_Verify var ise password olmalı

#created tarihlerinin bugunden eski oldugunun (buranin oncesinde tek parametreli bir method olusturursunuz ve direk method cagirma ozelligini kullanirsiniz)

#facebook google ve linkedin den kullanarak hesap acan kullanicilarin sayilarini bulur ve bu kullanicilarinin hepsinin roles lerinde ROLE_CLIENT_VERIFIED oldugunun assertion i yaparsiniz
# (eger bir kullanici mesela google kullanarak hesap actiysa google id si oluyor database de ve role turunu enum dan cekebilirseniz onun da son tekrarini yapmis oluruz ) (edited)

Feature: Client Table assertion

  Background:
    Given user gets all clients info from DB

  Scenario: TC-01 Clients id verification
    Then user verifies all clients have id

  Scenario: TC-02 Clients-email verification
    Then user verifies all clients have email

  Scenario: TC-03 Password-Role_client_verify verification
    Then user verifies there is password if role_client_verify is exist

  Scenario: TC-04 Created date is past time verification
    Then user verifies created date is past

  Scenario: TC-05 number of google_id, Linkedin_id, facebook_id
    Then user gets number of google, Linkedin, facebook accounts

  Scenario: TC-06 google_id/ Linkedin_id/ facebook_id -Role_client_verify verication
    Then user verifies there is role_client_verify when google_id - Linkedin_id - facebook_id is exist