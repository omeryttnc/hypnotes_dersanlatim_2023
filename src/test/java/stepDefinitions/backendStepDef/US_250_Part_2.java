package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.API;

import static stepDefinitions.Hooks.response;

public class US_250_Part_2 {
    private String addressTitle = Faker.instance().address().state();
    private String address = Faker.instance().address().streetAddress();
    private String zipcode = "12345";
    private String timeZone = "Turkey Standard Time";
    private int locationId;
    private String updatedAddressTitle = Faker.instance().address().state();
    ;
    private String updatedAddress = Faker.instance().address().streetAddress();
    ;
    private String updatedZipcode = "98765";
    API api = new API(USER_INFO.THERAPIST);


    @When("user sends a request for adding a locationTwo")
    public void userSendsARequestForAddingALocation() {
        locationId = api.getLocationApi().addLocation(addressTitle, address, zipcode, timeZone);
    }

    @Then("user verifies success is true")
    public void userVerifiesSuccessIsTrue() {
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
    }

    @And("user verifies that response is as expected for add locationTwo")
    public void userVerifiesThatResponseIsAsExpectedForAddLocation() {
        Assert.assertEquals(addressTitle, response.jsonPath().getString("locationInfo.addressTitle"));
        Assert.assertEquals(address, response.jsonPath().getString("locationInfo.address"));
        Assert.assertEquals(zipcode, response.jsonPath().getString("locationInfo.zipCode"));
        Assert.assertEquals(timeZone, response.jsonPath().getString("locationInfo.timeZone"));
    }

    @When("user sends a request for deleting added locationTwo")
    public void userSendsARequestForDeletingAddedLocation() {
        api.getLocationApi().deleteLocation(locationId);
    }

    @And("user sends a request for getting all locationTwo")
    public void userSendsARequestForGettingAllLocations() {
        api.getLocationApi().getLocation();
    }

    @And("user verifies that response is as expected for get locationTwo")
    public void userVerifiesThatResponseIsAsExpectedForGetLocation() {
        Assert.assertTrue(response.jsonPath().getList("locationInfos.id").contains(locationId));

        Assert.assertEquals(locationId, response.jsonPath().getInt("locationInfos[0].id"));
    }

    @And("user sends a request for updating added locationTwo")
    public void userSendsARequestForUpdatingAddedLocation() {
        api.getLocationApi().updateLocation(locationId, updatedAddressTitle, updatedAddress, updatedZipcode);
    }

    @And("user verifies that response is as expected for update locationTwo")
    public void userVerifiesThatResponseIsAsExpectedForUpdateLocation() {
        Assert.assertEquals(updatedAddressTitle, response.jsonPath().getString("locationInfo.addressTitle"));
        Assert.assertEquals(updatedAddress, response.jsonPath().getString("locationInfo.address"));
        Assert.assertEquals(updatedZipcode, response.jsonPath().getString("locationInfo.zipCode"));

    }
}
