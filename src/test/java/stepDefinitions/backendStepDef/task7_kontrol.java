package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ClientPage;
import pages.CommonPage;
import utilities.API;
import utilities.BrowserUtilities;
import utilities.CLIENTS_API;

import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;

public class task7_kontrol extends CommonPage {
    String firstName;
    String lastName;
    String email;
    Faker faker = new Faker();

    CLIENTS_API.PGetClientInfo getClient;

    @Given("user adds a client from UI")
    public void userAddsAClientFromUI() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();

        BrowserUtilities.waitFor(5);
        getClientPage().clients_sideBar.click();

        getClientPage().addNewClient.click();

        getClientPage().register_firstName.sendKeys(firstName);
        getClientPage().register_lastName.sendKeys(lastName);
        getClientPage().register_email.sendKeys(email);

        "Save".clickWebElementByText();

        "Yes".clickWebElementByText();
    }

    @When("user sends a request for getting all clients")
    public void userSendsARequestForGettingAllClients() {
        API api = new API(USER_INFO.THERAPIST);
        getClient=api.getClientsApi().getClient();
    }

    @Then("user verifies that created client is exist in response")
    public void userVerifiesThatCreatedClientIsExistInResponse() {
        Assert.assertTrue(getClient.isSuccessTrue());

        //way 1 Structural
        Assert.assertTrue(getClient.clientNameList().contains(firstName));
        Assert.assertTrue(getClient.clientSurnameList().contains(lastName));
        Assert.assertTrue(getClient.clientEmailList().contains(email));

        //way 2 Functional
        Assert.assertTrue(getClient.clientNameList().stream().anyMatch(t->t.contains(firstName)));
        Assert.assertTrue(getClient.clientSurnameList().stream().anyMatch(t->t.contains(lastName)));
        Assert.assertTrue(getClient.clientEmailList().stream().anyMatch(t->t.contains(email)));

        Assert.assertEquals(200,getClient.statusCode());
    }

    @And("user deletes added client from UI")
    public void userDeletesAddedClientFromUI() {
        BrowserUtilities.waitFor(5);
        getClientPage().clients_sideBar.click();

        int clientSize = getClientPage().getClientSize();

        for (int i = 0; i < clientSize; i++) {
            ClientPage.ClientInfo clientInfo=getClientPage().getClientInfo(i);

            if (clientInfo.clientName().equals(firstName) || clientInfo.clientEmail().equals(email)) {
                getClientPage().deleteButton.get(i).click();
                break;
            }
        }

        "Yes".clickWebElementByText();
    }


    @Then("user verifies that deleted client is not exist in response")
    public void userVerifiesThatDeletedClientIsNotExistInResponse() {
        Assert.assertTrue(getClient.isSuccessTrue());

        Assert.assertFalse(getClient.clientNameList().contains(firstName));
        Assert.assertFalse(getClient.clientSurnameList().contains(lastName));
        Assert.assertFalse(getClient.clientEmailList().contains(email));

        //way 2 Functional
        Assert.assertTrue(getClient.clientNameList().stream().noneMatch(t->t.contains(firstName)));
        Assert.assertTrue(getClient.clientSurnameList().stream().noneMatch(t->t.contains(lastName)));
        Assert.assertTrue(getClient.clientEmailList().stream().noneMatch(t->t.contains(email)));

        Assert.assertEquals(200,getClient.statusCode());
    }
}
