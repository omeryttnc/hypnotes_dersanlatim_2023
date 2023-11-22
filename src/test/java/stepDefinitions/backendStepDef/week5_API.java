package stepDefinitions.backendStepDef;

import enums.USER_INFO;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.API;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.PHPSESSID;
import static stepDefinitions.Hooks.response;

public class week5_API {
    Response responseInner;

    @Given("from step def String kullanarak")
    public void fromStepDefStringKullanarak() {


        responseInner = given() // api ya giris yaptik
                .contentType(ContentType.JSON) //gonderecegimiz degerin hangi tur oldugunu belirledik
                // auth olmadigi icin buraya eklemeyecegiz
                .body("{\"username\":\"therapist2023@mailsac.com\",\"password\":\"12ASDasd.,asdASD34\"}") // gonderecegimiz body/bilgiyi ekliyoruz
                .post("https://test.hypnotes.net/api/login"); // hangi methodu kullaniyoruz ve hangi endpoint i kullanacagiz belirlememiz gerekiyor

        responseInner.prettyPrint();

    }

    @Given("from step def map kullanarak")
    public void fromStepDefMapKullanarak() {
        Map<String,String> mapBody= new HashMap<>();
        mapBody.put("username","therapist2023@mailsac.com");
        mapBody.put("password","12ASDasd.,asdASD34");

        responseInner = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("https://test.hypnotes.net/api/login");

        responseInner.prettyPrint();
    }

    @Given("from step def inner class kullanarak")
    public void fromStepDefInnerClassKullanarak() {

       InnerRecordBody innerRecordBody =new InnerRecordBody("therapist2023@mailsac.com","12ASDasd.,asdASD34");


        responseInner = given()
                .contentType(ContentType.JSON)
                .body(innerRecordBody)
                .post("https://test.hypnotes.net/api/login");

        responseInner.prettyPrint();
    }

    @Given("from Api utilities")
    public void fromApiUtilities() {
        ApiUtilities.getToken("therapist2023@mailsac.com","12ASDasd.,asdASD34");

    }

    @Given("from Inner Class")
    public void fromInnerClass() {
        API api =new API(USER_INFO.THERAPIST);

        response.prettyPrint();
        System.out.println("PHPSESSID = " + PHPSESSID);

    }
    record InnerRecordBody(String username,String password){}


    class InnerClassBody{
        private String username,password;

        public InnerClassBody(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
