package stepDefinitions.backendStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US_220_221_222_223 {
    Response response200;
    Map<String, Object> payload = new HashMap<>();
    String phpSessId;
    private int recurringBlockId;
    private List<Integer> recurringIds = new ArrayList<>();

    @Given("user take token from api")
    public void userTakeTokenFromApi() {
        payload.put("username", "test_trpst_basic@yopmail.com");
        payload.put("password", "Trpst13.");

        response200 = given().body(payload).post("https://test.hypnotes.net/api/login");
        response200.prettyPrint();
        Assert.assertTrue(response200.jsonPath().getBoolean("authenticated"));
        phpSessId = response200.cookie("PHPSESSID");
        System.out.println("phpSessId = " + phpSessId);


    }

    @Then("user creates a Recurring Block Time from api")
    public void userCreatesARecurringBlockTimeFromApi() {
        payload.put("startAt", "17:30");
        payload.put("finishAt", "19:30");
        payload.put("isRecurring", true);
        payload.put("recurringDays[0]", "sunday");
        payload.put("title", "Online");

        response200 = given()
                .header("cookie", "PHPSESSID=" + phpSessId)
                .formParams(payload)
                .post("https://test.hypnotes.net/api/hypnotherapist/timeoff/create");

        response200.prettyPrint();
        recurringBlockId = response200.jsonPath().getInt("data[0].id");
        System.out.println("recurringBlockId = " + recurringBlockId);

    }

    @And("user verifies status is true")
    public void userVerifiesStatusIsTrue() {
        Assert.assertTrue(response200.jsonPath().getBoolean("status"));

    }

    @And("user verifies that response is as expected")
    public void userVerifiesThatResponseIsAsExpected() {
        Assert.assertEquals("17:30", response200.jsonPath().getString("data[0].startAt"));
        Assert.assertEquals("19:30", response200.jsonPath().getString("data[0].finishAt"));
        Assert.assertEquals("sunday", response200.jsonPath().getString("data[0].recurringDays[0]"));
        Assert.assertEquals("Online", response200.jsonPath().getString("data[0].locationTitle"));
    }

    @Then("user gets all Recurring Block Times from api")
    public void userGetsAllRecurringBlockTimesFromApi() {
        response200 = given().header("cookie", "PHPSESSID=" + phpSessId)
                .post("https://test.hypnotes.net/api/hypnotherapist/timeoff/all");
        response200.prettyPrint();
        recurringIds = response200.jsonPath().getList("data.id");
        System.out.println("recurringIds = " + recurringIds);
    }

    @And("user verifies created Block Time is exist in response")
    public void userVerifiesCreatedBlockTimeIsExistInResponse() {
        Assert.assertTrue(recurringIds.contains(recurringBlockId));
    }

    @Then("user updates a Recurring Block Time from api")
    public void userUpdatesARecurringBlockTimeFromApi() {
    }

    @Then("user deletes the recurring Block Time from api")
    public void userDeletesTheRecurringBlockTimeFromApi() {
        payload.put("id", recurringBlockId);

        response200 = given().header("cookie", "PHPSESSID=" + phpSessId)
                .formParams(payload)
                .post("https://test.hypnotes.net/api/hypnotherapist/timeoff/delete");
        response200.prettyPrint();
    }

    @And("user verifies deleted Block Time is not exist in response")
    public void userVerifiesDeletedBlockTimeIsNotExistInResponse() {
        Assert.assertFalse(recurringIds.contains(recurringBlockId));
    }
}
