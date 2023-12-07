#database deki butun clientleri donduren bir method olusturun. methodun return u List<CreatedClient> olacak sekilde ayarlayabilirseniz
#bu listedeki Client lerin hepsinin
#
#id si oldugunun assertion i yapin
#email lerinin oldugunun (burada bug olabilir cunku bazi kullancilarin mailleri null yani bu test fail olacak)
#hic bir kullanicinin password null olmadiginin assertion i (bu da fail olacak burada da bug olabilir)
#created tarihlerinin bugunden eski oldugunun (buranin oncesinde tek parametreli bir method olusturursunuz ve direk method cagirma ozelligini kullanirsiniz)
#name ve surname lerinin icerisinde buyuk harf, kucuk harf numara ve 8 karakterden fazla oldugunu
#facebook google ve linkedin den kullanarak hesap acan kullanicilarin sayilarini bulur ve bu kullanicilarinin hepsinin
#roles lerinde ROLE_CLIENT_VERIFIED oldugunun assertion i yaparsiniz (eger bir kullanici mesela google kullanarak hesap actiysa google id si oluyor database de
#ve role turunu enum dan cekebilirseniz onun da son tekrarini yapmis oluruz)