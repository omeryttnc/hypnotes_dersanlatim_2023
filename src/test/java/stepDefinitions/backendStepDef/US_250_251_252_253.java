package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;

public class US_250_251_252_253 {
    private String phpSessId;
    private int locationId;
    private List<Integer> locationIdsList = new ArrayList<>();
    private int locationFirstId;
    private String addressTitle = Faker.instance().address().state();
    private String address = Faker.instance().address().streetAddress();
    private String zipcode = "12345";
    private String timeZone = "Turkey Standard Time";
    private String updatedAddressTitle = Faker.instance().address().state();;
    private String updatedAddress = Faker.instance().address().streetAddress();;
    private String updatedZipcode = "98765";
    private Map<String, Object> requestBody = new HashMap<>();
    private Response response250;

    @Given("user sends a request for phpSessId")
    public void userSendsARequestForPhpSessId() {
        requestBody.put("username", "test_trpst_location@yopmail.com");
        requestBody.put("password", "Trpst13.");

        response250 = given().body(requestBody).post("https://test.hypnotes.net/api/login");
        response250.prettyPrint();

        Assert.assertTrue(response250.jsonPath().getBoolean("authenticated"));

        phpSessId = response250.cookie("PHPSESSID");
        System.out.println("phpSessId = " + phpSessId);
    }

    @When("user sends a request for adding a location")
    public void userSendsARequestForAddingALocation() {
        requestBody.put("addressTitle", addressTitle);
        requestBody.put("address", address);
        requestBody.put("zipCode", zipcode);
        requestBody.put("timeZone", timeZone);

        response250 = given()
                .header("cookie", "PHPSESSID=" + phpSessId)
                // .contentType(ContentType.URLENC)
                .formParams(requestBody)
                .post("https://test.hypnotes.net/api/settings/location/add");

        response250.prettyPrint();

        locationId = response250.jsonPath().getInt("locationInfo.id");
    }

    @Then("user verifies success is true for location")
    public void userVerifiesSuccessIsTrueForLocation() {
        Assert.assertTrue(response250.jsonPath().getBoolean("success"));
    }

    @And("user verifies that response is as expected for add location")
    public void userVerifiesThatResponseIsAsExpectedForAddLocation() {
        Assert.assertEquals(addressTitle, response250.jsonPath().getString("locationInfo.addressTitle"));
        Assert.assertEquals(address, response250.jsonPath().getString("locationInfo.address"));
        Assert.assertEquals(zipcode, response250.jsonPath().getString("locationInfo.zipCode"));
        Assert.assertEquals(timeZone, response250.jsonPath().getString("locationInfo.timeZone"));
    }

    @When("user sends a request for deleting added location")
    public void userSendsARequestForDeletingAddedLocation() {
        requestBody.put("id", locationId);

        response250 = given()
                .header("cookie", "PHPSESSID=" + phpSessId)
                // .contentType(ContentType.URLENC)
                .formParams(requestBody)
                .post("https://test.hypnotes.net/api/settings/location/delete");

        response250.prettyPrint();
    }

    @And("user sends a request for geting all locations")
    public void userSendsARequestForGetingAllLocations() {
        response250=given()
                    .header("cookie","PHPSESSID="+phpSessId)
                    .post("https://test.hypnotes.net/api/dashboard/getUser");

        response250.prettyPrint();

    }

    @And("user verifies that response is as expected for get location")
    public void userVerifiesThatResponseIsAsExpectedForGetLocation() {
        locationFirstId=response250.jsonPath().getInt("locationInfos[0].id");
        System.out.println("locationFirstId = " + locationFirstId);

        locationIdsList=response250.jsonPath().getList("locationInfos.id");
        System.out.println("locationIdsList = " + locationIdsList);

        Assert.assertEquals(locationId,locationFirstId);

        Assert.assertTrue(locationIdsList.contains(locationId));
    }

    @And("user sends a request for updating added location")
    public void userSendsARequestForUpdatingAddedLocation() {
        System.out.println("locationId = " + locationId);

        requestBody.put("id",locationId);
        requestBody.put("addressTitle", updatedAddressTitle);
        requestBody.put("address", updatedAddress);
        requestBody.put("zipCode", updatedZipcode);
        requestBody.put("timeZone", timeZone);


        response250 = given()
                .header("cookie","PHPSESSID="+phpSessId)
                // .contentType(ContentType.URLENC)
                .formParams(requestBody)
                .post("https://test.hypnotes.net/api/settings/location/update");

        response250.prettyPrint();

    }

    @And("user verifies that response is as expected for update location")
    public void userVerifiesThatResponseIsAsExpectedForUpdateLocation() {
        Assert.assertEquals(updatedAddressTitle, response250.jsonPath().getString("locationInfo.addressTitle"));
        Assert.assertEquals(updatedAddress, response250.jsonPath().getString("locationInfo.address"));
        Assert.assertEquals(updatedZipcode, response250.jsonPath().getString("locationInfo.zipCode"));
    }

}
