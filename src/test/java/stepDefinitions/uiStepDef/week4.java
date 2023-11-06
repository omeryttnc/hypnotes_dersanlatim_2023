package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import utilities.BrowserUtilities;

import java.time.Duration;

import static stepDefinitions.Hooks.*;

public class week4 extends CommonPage {
    @When("user clicks on Documents on the side bar")
    public void userClicksOnDocumentsOnTheSideBar() {
        commonPage.getHomePage().side_documents.click();
    }

    @Then("Add New Document should be visible")
    public void addNewDocumentShouldBeVisible() {
        System.out.println("commonPage.getDocumentsPage().addNewDocument.isDisplayed() = " + commonPage.getDocumentsPage().addNewDocument.isDisplayed());
    }

    @When("user clicks on Add New Document button")
    public void userClicksOnAddNewDocumentButton() {
        commonPage.getDocumentsPage().addNewDocument.click();
    }

    @Then("user should be on upload page")
    public void userShouldBeOnUploadPage() {

     BrowserUtilities.waitForVisibility(getDocumentsPage().selectFile_wrong);
System.out.println("driver.getCurrentUrl().contains(\"dashboard/documents/upload\") = " + driver.getCurrentUrl().contains("dashboard/documents/upload"));
    }

    @And("cancel, upload, select file should be visible")
    public void cancelUploadSelectFileShouldBeVisible() {
        System.out.println("getDocumentsPage().addNewDocument_cancel.isDisplayed() = " + getDocumentsPage().addNewDocument_cancel.isDisplayed());
        System.out.println("deger 0");
        getDocumentsPage().checkTag(0);
    }

    @When("user clicks on Cancel button")
    public void userClicksOnCancelButton() {
        getDocumentsPage().addNewDocument_cancel.click();
    }

    @Then("user should be able to upload document")
    public void userShouldBeAbleToUploadDocument() {
        commonPage.getDocumentsPage().selectFile_correct.sendKeys("C:\\Users\\HAVVA\\IdeaProjects\\KesifPlus_Hypnotes_DersAnlatim\\src\\test\\resources\\KesifPlusPdfSample.pdf");
    }

    @And("file Name window should be active when the file is added")
    public void fileNameWindowShouldBeActiveWhenTheFileIsAdded() {
        BrowserUtilities.waitFor(2);
        System.out.println("commonPage.getDocumentsPage().addedFile.getText() = " + commonPage.getDocumentsPage().addedFile.getText());
    }

    @When("you click the Next button, the Add Annotation section should be visible")
    public void youClickTheNextButtonTheAddAnnotationSectionShouldBeVisible() {


    }
    @And("you click the Next button")
    public void youClickTheNextButton() {
        commonPage.getDocumentsPage().nextButton.click();
    }

    @Then("the Add Annotation section should be visible")
    public void theAddAnnotationSectionShouldBeVisible() {
        System.out.println("deger 1");
        BrowserUtilities.waitForVisibility(getDocumentsPage().previewButton);
        commonPage.getDocumentsPage().checkTag(1);
    }

    @When("user click on view Guide")
    public void userClickOnViewGuide() {
        getDocumentsPage().viewGuideButton.click();
    }

    @Then("OK and cancel button should be visible")
    public void okAndCancelButtonShouldBeVisible() {
        System.out.println("getDocumentsPage().okButton.isDisplayed() = " + getDocumentsPage().okButton.isDisplayed());
        System.out.println("getDocumentsPage().cancelButton.isDisplayed() = " + getDocumentsPage().cancelButton.isDisplayed());
    }

    @And("video should play when click view guide")
    public void videoShouldPlayWhenClickViewGuide() {
      //  driver.switchTo().frame(getDocumentsPage().videoFrame);
        System.out.println("getDocumentsPage().getCurrentTime() = " + getDocumentsPage().getCurrentTime());
//        getDocumentsPage().videoPlay.click();
        BrowserUtilities.waitFor(3);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).build().perform();
        BrowserUtilities.waitFor(3);
        System.out.println("getDocumentsPage().getCurrentTime() = " + getDocumentsPage().getCurrentTime());
    }

    @And("cancel and OK buttons must be visible")
    public void cancelAndOKButtonsMustBeVisible() {

        System.out.println("getDocumentsPage().cancelButton.isDisplayed() = " + getDocumentsPage().cancelButton.isDisplayed());
    }

    @And("add Text Field, Add Checkbox, Add Signature Field, Add Text Input, Add Signature Input, Previus Page, Next Page, Zoom In, Zoom Out buttons should be visible")
    public void addTextFieldAddCheckboxAddSignatureFieldAddTextInputAddSignatureInputPreviusPageNextPageZoomInZoomOutButtonsShouldBeVisible() {
    }

    @When("user clicks on signature field")
    public void userClicksOnSignatureField() {
        getDocumentsPage().addSignatureField.click();
    }

    @Then("signature field should be able to be generated")
    public void signatureFieldShouldBeAbleToBeGenerated() {
        System.out.println("getDocumentsPage().signatureField.isDisplayed() = " + getDocumentsPage().signatureField.isDisplayed());
    }

    @When("user clicks on Preview button")
    public void userClicksOnPreviewButton() {
        getDocumentsPage().previewButton.click();
    }


    @And("Save button should be visible")
    public void saveButtonShouldBeVisible() {
        BrowserUtilities.waitForVisibility(getDocumentsPage().saveButton);
        System.out.println("getDocumentsPage().saveButton.isDisplayed() = " + getDocumentsPage().saveButton.isDisplayed());
    }

    @When("user clicks on save button")
    public void userClicksOnSaveButton() {
        getDocumentsPage().saveButton.click();
    }

    @When("user click on delete button to delete document")
    public void userClickOnDeleteButtonToDeleteDocument() {
        getDocumentsPage().deleteVideo.click();
    }



}
