package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class week2_US008_US039 extends CommonPage {
    @Given("user goes to login page")
    public void userGoesToLoginPage() {
        driver.get("https://test.hypnotes.net/login");
    }

    @And("user sends password {string}")
    public void userSendsPassword(String password) {
        getLoginPage().loginAsClientPage_password.sendKeys(password);

    }

    @When("user sends invalid emails and check if user gets proper warning")
    public void userSendsInvalidEmailsAndCheckIfUserGetsProperWarning(DataTable dataTable) {
        List<String> invalidEmails = dataTable.column(0);
        List<String> expectedValidationMessage = dataTable.column(1);

        for (int i = 0; i < invalidEmails.size(); i++) {

            getLoginPage().loginAsClientPage_email.sendKeys(invalidEmails.get(i));
            getLoginPage().loginAsClientPage_loginButton.click();

            String actualValidationMessage = BrowserUtilities.getValidationMessage(commonPage.getLoginPage().loginAsClientPage_email);

            Assert.assertEquals(expectedValidationMessage.get(i), actualValidationMessage);

            // way 1
            getLoginPage().loginAsClientPage_email.clear();

            //way 2
            //  BrowserUtilities.clearWebelement(commonPage.getLoginPage().loginAsClientPage_email);

        }


    }


    @And("user sends email as {string}")
    public void userSendsEmailAs(String email) {
        getLoginPage().loginAsClientPage_email.sendKeys(email);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        getLoginPage().loginAsClientPage_loginButton.click();
    }

    @Then("user should be able to see {string} as alert message")
    public void userShouldBeAbleToSeeAsAlertMessage(String expectedAlertMessage) {
         getHomePage().assertAlertMessage(expectedAlertMessage);

        //Assert.assertTrue(getHomePage().navbarList.getFirst().isDisplayed());
    }

    @Then("user should be able to see {string}")
    public void userShouldBeAbleToSee(String webelementText) {
        Assert.assertTrue(BrowserUtilities.getWebElementByUsingText(webelementText).isDisplayed());
    }

    @When("user click on next button")
    public void userClickOnNextButton() {

        BrowserUtilities.scrollToWebElement(getHomePage().bulletPoints.get(0));
        // Browser utilities
       BrowserUtilities. assertBackgroundColour("rgba(0, 0, 0, 1)",getHomePage().bulletPoints.get(1));
      //  Assert.assertEquals("rgba(0, 0, 0, 1)", getHomePage().bulletPoints.get(1).getCssValue("background-color"));
        getHomePage().clickNextButton();

        // extension kullanarak
        getHomePage().bulletPoints.get(0).assertBackgroundColor("rgba(0, 0, 0, 1)");
        //Assert.assertEquals("rgba(0, 0, 0, 1)", getHomePage().bulletPoints.get(0).getCssValue("background-color"));
        // standart step def icinde kullanarak
        Assert.assertEquals("rgba(127, 127, 127, 1)", getHomePage().bulletPoints.get(1).getCssValue("background-color"));
    }


    @Then("assert testimonials has changed")
    public void assertTestimonialsHasChanged() {
    }
}
