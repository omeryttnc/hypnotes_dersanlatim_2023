package stepDefinitions.backendStepDef;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class week5_API {
    Response response;

    @Given("from step def String kullanarak")
    public void fromStepDefStringKullanarak() {


        response = given() // api ya giris yaptik
                .contentType(ContentType.JSON) //gonderecegimiz degerin hangi tur oldugunu belirledik
                // auth olmadigi icin buraya eklemeyecegiz
                .body("{\"username\":\"therapist2023@mailsac.com\",\"password\":\"12ASDasd.,asdASD34\"}") // gonderecegimiz body/bilgiyi ekliyoruz
                .post("https://test.hypnotes.net/api/login"); // hangi methodu kullaniyoruz ve hangi endpoint i kullanacagiz belirlememiz gerekiyor

        response.prettyPrint();

    }

    @Given("from step def map kullanarak")
    public void fromStepDefMapKullanarak() {
      // yanlis kullanim  Assert.assertEquals(response.statusCode(), 200);
    }

    @Given("from step def inner class kullanarak")
    public void fromStepDefInnerClassKullanarak() {
    }

    @Given("from Api utilities")
    public void fromApiUtilities() {
    }

    @Given("from Inner Class")
    public void fromInnerClass() {
    }
}
