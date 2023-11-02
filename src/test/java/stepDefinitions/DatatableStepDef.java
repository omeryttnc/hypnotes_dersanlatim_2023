package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.util.List;
import java.util.Map;

import static stepDefinitions.Hooks.driver;

public class DatatableStepDef extends CommonPage {
    @When("user clicks language flag button user verifies that texts are changing according to the language")
    public void userClicksLanguageFlagButtonUserVerifiesThatTextsAreChangingAccordingToTheLanguage(DataTable dt) {
        List<String> texts = dt.column(1);
        System.out.println(texts);

        for (int i = 0; i < texts.size(); i++) {
            getHomePage().languageFlagButton.click();
            getHomePage().languageFlagList.get(i).click();
            BrowserUtilities.waitFor(1);
            Assert.assertTrue(getHomePage().finallyText.getText(), getHomePage().finallyText.getText().contains(texts.get(i)));

        }
    }

    @Given("user login as therapist with email {string} password {string}")
    public void userLoginAsTherapistWithEmailPassword(String email, String password) {
    getLoginPage().loginMethod(email,password);
        BrowserUtilities.waitFor(3);
        try {
            WebElement no = driver.findElement(By.xpath("//*[text()='No']"));
            no.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BrowserUtilities.waitFor(3);
    }

    @And("user clicks Services")
    public void userClicksServices() {
        getServicesPage().servicesTab.click();
        BrowserUtilities.waitFor(2);

    }
    @And("user clicks Add New Individual Session Button")
    public void userClicksAddNewIndividualSessionButton() {
        getServicesPage().addNewIndividualSession.click();
    }



    //datatable da boş hücrenin hata vermesini engellemek için if-else kullanarak boş datanın yerini "" ile doldurmak gerekiyor.
    //isEmpty() metodu kullanılırsa hata veriyor, ...==null koduyla doğrulama yapılabilir.

    @And("user remaines inputs empty and verifies alert message")
    public void userRemainesInputsEmptyAndVerifiesAlertMessage(DataTable dt) {
        List<Map<String, String>> individualSessionData = dt.asMaps();
        int i=0;
        for (Map<String, String> data : individualSessionData) {
            i++;
            System.out.println(i);
            String name=data.get("name");
            String price=data.get("price");
            String duration=data.get("duration");
            String blockBefore=data.get("blockBefore");
            String blockAfter=data.get("blockAfter");
            getServicesPage().nameBoxIndividual.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            if (name==null){ getServicesPage().nameBoxIndividual.sendKeys("");}else {
            getServicesPage().nameBoxIndividual.sendKeys(name);
            }
            getServicesPage().priceBoxIndividual.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
            if (price==null){getServicesPage().priceBoxIndividual.sendKeys("");}else{
            getServicesPage().priceBoxIndividual.sendKeys(price);
            }
            if (duration==null){getServicesPage().durationBoxIndividual.sendKeys("");}else{
            getServicesPage().durationBoxIndividual.sendKeys(duration);
            }
            getServicesPage().blockBeforeBoxIndividual.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
            if (blockBefore==null){getServicesPage().blockBeforeBoxIndividual.sendKeys("");}else{
            getServicesPage().blockBeforeBoxIndividual.sendKeys(blockBefore);
            }
            getServicesPage().blockAfterBoxIndividual.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
            if (blockAfter==null){getServicesPage().blockAfterBoxIndividual.sendKeys("");}else{
            getServicesPage().blockAfterBoxIndividual.sendKeys(blockAfter);
            }
            getServicesPage().saveButtonIndividual.click();
            Assert.assertTrue(getServicesPage().errorMessage.getText(), getServicesPage().errorMessage.getText().contains(data.get("warning")));
        }
    }
}
