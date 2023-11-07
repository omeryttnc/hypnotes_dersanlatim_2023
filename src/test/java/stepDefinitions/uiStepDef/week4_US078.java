package stepDefinitions.uiStepDef;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.BrowserUtilities;

import javax.sql.rowset.BaseRowSet;

import java.io.File;
import java.io.IOException;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class week4_US078 extends CommonPage {
    String fakeFile;
    @When("user clicks on Documents on the side bar")
    public void userClicksOnDocumentsOnTheSideBar() {
        getHomePage().side_documents.click();
    }

    @Then("Add New Document should be visible")
    public void addNewDocumentShouldBeVisible() {
        Assert.assertTrue(getDocumentsPage().addNewDocument.isDisplayed());
//        Assert.assertEquals(getDocumentsPage().addNewDocument.getText(), "Add New Document");
    }

    @When("user clicks on Add New Document button")
    public void userClicksOnAddNewDocumentButton() {
        getDocumentsPage().addNewDocument.click();
    }

    @Then("user should be on upload page")
    public void userShouldBeOnUploadPage() {
//        BrowserUtilities.waitFor(2);
        Assert.assertTrue(getDocumentsPage().selectFile_wrong.isDisplayed()); // selenium yavaslatmak

        Assert.assertTrue("url was : " + driver.getCurrentUrl()
                , driver.getCurrentUrl().contains("upload"));
    }

    @And("cancel, upload, select file should be visible")
    public void cancelUploadSelectFileShouldBeVisible() {
        Assert.assertTrue(getDocumentsPage().selectFile_wrong.isDisplayed());
    }

    @When("user clicks on Cancel button")
    public void userClicksOnCancelButton() {
        getDocumentsPage().addNewDocument_cancel.click();
    }

    @When("user should be able to upload document")
    public void userShouldBeAbleToUploadDocument() {
         fakeFile = BrowserUtilities.createFakeFile();
        getDocumentsPage().selectFile_correct.sendKeys(BrowserUtilities.getFakeFilePath(fakeFile));
        BrowserUtilities.waitFor(2);
    }


    @And("file Name window should be active when the file is added")
    public void fileNameWindowShouldBeActiveWhenTheFileIsAdded() {
     //   System.out.println("getDocumentsPage().addedFile.getText() = " + getDocumentsPage().addedFile.getText());
        Assert.assertEquals(fakeFile,getDocumentsPage().addedFile.getText());
    }

    @And("you click the Next button")
    public void youClickTheNextButton() {
        getDocumentsPage().nextButton.click();
    }

    @Then("the Add Annotation section should be visible")
    public void theAddAnnotationSectionShouldBeVisible() {
        BrowserUtilities.waitForVisibility(getDocumentsPage().previewButton);
        BrowserUtilities.waitFor(1);
        getDocumentsPage().checkTag(1);
    }

    @When("user click on view Guide")
    public void userClickOnViewGuide() {
        getDocumentsPage().viewGuideButton.click();
    }

    @Then("OK and cancel button should be visible")
    public void okAndCancelButtonShouldBeVisible() {
        BrowserUtilities.waitForVisibility(getDocumentsPage().okButton);
      Assert.assertTrue(  getDocumentsPage().okButton.isDisplayed());
      Assert.assertTrue(  getDocumentsPage().cancelButton.isDisplayed());
    }

    @And("video should play when click view guide")
    public void videoShouldPlayWhenClickViewGuide() {
        Double firstTime = getDocumentsPage().getCurrentTime();
        Assert.assertEquals(firstTime,0,0);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).build().perform();
        BrowserUtilities.waitFor(3);

        Double secondTime = getDocumentsPage().getCurrentTime();
        Assert.assertTrue(secondTime>0);
        Assert.assertTrue(secondTime>firstTime);


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
        BrowserUtilities.waitForVisibility(getDocumentsPage().signatureField);
        Assert.assertTrue(getDocumentsPage().signatureField.isDisplayed());
    }

    @When("user clicks on Preview button")
    public void userClicksOnPreviewButton() {
        getDocumentsPage().previewButton.click();
    }

    @And("Save button should be visible")
    public void saveButtonShouldBeVisible() {
       Assert.assertTrue( getDocumentsPage().saveButton.isDisplayed());
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
