package stepDefinitions.uiStepDef;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.optim.univariate.BracketFinder;
import org.junit.Assert;
import pages.ClientPage;
import pages.CommonPage;
import pages.HomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import static stepDefinitions.Hooks.driver;

public class week3 extends CommonPage {
    @Given("user login as therapist")
    public void userLoginAsTherapist() {
        // way 1 enum
        //  getLoginPage().loginMethod(USER_INFO.THERAPIST.getEmail(),USER_INFO.THERAPIST.getPassword());

        // way 2 config
//        getLoginPage().loginMethod(
//                ConfigurationReader.getProperty("therapistEmail"),
//                ConfigurationReader.getProperty("therapistPassword")
//        );

        // way 3 tag
        // @therapist

    }

    @And("refresh page")
    public void refreshPage() {
        BrowserUtilities.waitFor(2);
        driver.navigate().refresh();
        BrowserUtilities.waitFor(2);
    }

    @And("user clicks on Clients Page")
    public void userClicksOnClientsPage() {
        BrowserUtilities.waitFor(5);
        getClientPage().clients_sideBar.click();
    }

    @When("user click on Add New Client button")
    public void userClickOnAddNewClientButton() {
        getClientPage().addNewClient.click();
    }

    @Then("user should be able to see Add New Client form")
    public void userShouldBeAbleToSeeAddNewClientForm() {
        // way 1
        Assert.assertTrue(getClientPage().addNewClient_text.isDisplayed());

        // way 2
        Assert.assertTrue(
                "Add new client yazisi gelmedi",
                getClientPage().addNewClient_text.getText().equals("Add New Client")
        );

        // way 3
        Assert.assertEquals("Add New Client", getClientPage().addNewClient_text.getText());
    }

    String firstName;
    String lastName;
    String email;
    String phoneNumber;

    @When("user enter new client information's")
    public void userEnterNewClientInformationS() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        phoneNumber = faker.phoneNumber().phoneNumber();

        getClientPage().register_firstName.sendKeys(firstName);
        getClientPage().register_lastName.sendKeys(lastName);
        getClientPage().register_email.sendKeys(email);
        getClientPage().register_phone.sendKeys(phoneNumber);

        //wau 1
       // BrowserUtilities.getWebElementByUsingText("Save").click();

        // way 2
        "Save".clickWebElementByText();
    }

    @When("user click on Yes button")
    public void userClickOnYesButton() {
        //BrowserUtilities.getWebElementByUsingText("Yes").click();

        "Yes".clickWebElementByText();

    }

    @Then("user should able to see created client")
    public void userShouldAbleToSeeCreatedClient() {

        boolean flag= false;

        int clientSize = getClientPage().getClientSize();

        for (int i = 0; i < clientSize; i++) {
            ClientPage.ClientInfo clientInfo = getClientPage().getClientInfo(i);

            if(clientInfo.clientEmail().equals(email)){
                flag =true;
                break;
            }
        }

        Assert.assertTrue("aradiginiz client e su an ulasilamiyor !!! ",flag);


    }

    @When("user click on delete button")
    public void userClickOnDeleteButton() {
        getClientPage().deleteButton.get(0).click();
    }

    @Then("user should see {string} caution message")
    public void userShouldSeeCautionMessage(String expectedCautionMessage) {
        BrowserUtilities.waitForVisibility(getClientPage().cautionMessage);
        Assert.assertEquals(expectedCautionMessage,getClientPage().cautionMessage.getText());
    }

    @And("assert user is deleted")
    public void assertUserIsDeleted() {

        boolean flag= false;

        int clientSize = getClientPage().getClientSize();

        for (int i = 0; i < clientSize-1; i++) {
            ClientPage.ClientInfo clientInfo = getClientPage().getClientInfo(i);

            if(clientInfo.clientEmail().equals(email)){
                flag =true;

            }
        }

        Assert.assertFalse("olusturmus oldugunuz client silinemedi ",flag);

    }


}
