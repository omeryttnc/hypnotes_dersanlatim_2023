package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class DocumentsPage extends CommonPage {

    @FindBy(css = "[data-test-id='documents_addDocument']")
    public WebElement addNewDocument;

    @FindBy(css = "[data-test-id='documents_Cancel']")
    public WebElement addNewDocument_cancel;
    @FindBy(css = "[data-test-id='documents_stepNext']")
    public WebElement nextButton;

    @FindBy(css = "div.ant-steps-item .ant-steps-item-icon")
    private List<WebElement> upload_0$addAnnotation_1$preview_2;

    @FindBy(css = ".ant-btn.css-aqx16b.ant-btn-default:not([data-test-id])")
    public WebElement selectFile_wrong;

    @FindBy(css = "span input[type='file']")
    public WebElement selectFile_correct;

    @FindBy(css = "span.ant-upload-list-item-name")
    public WebElement addedFile;
    @FindBy(css = "[title='Add Signature Field']")
    public WebElement addSignatureField;
    @FindBy(css = ".hypnotes-pdf-move")
    public WebElement signatureField;

    @FindBy(css = "[data-tagging-id]")
    public WebElement videoFrame;
    @FindBy(css = "video[src]")
    public WebElement videoPlay;

    @FindBy(xpath = "//button[text()='Preview']")
    public WebElement previewButton;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='View Guide']")
    public WebElement viewGuideButton;
    @FindBy(css = "li:last-of-type .flex-column.align-items-center")
    public WebElement deleteVideo;
    @FindBy(css = "div.ant-modal-footer button:nth-last-child(1)") // nth-child(2) last-of-type
    public WebElement okButton;


    @FindBy(css = "div.ant-modal-footer button:first-of-type")
    public WebElement cancelButton;


    public String getCurrentTime() {
        return videoPlay.getAttribute("currentTime");
    }

    public void checkTag(int index) {
        BrowserUtilities.waitForVisibility(upload_0$addAnnotation_1$preview_2.get(index));
        BrowserUtilities.waitFor(1);
        System.out.println("upload_0$addAnnotation_1$preview_2.get(index).isEnabled() = " + upload_0$addAnnotation_1$preview_2.get(index).isEnabled());
        System.out.println("upload_0$addAnnotation_1$preview_2.get(index).getCssValue(\"background-color\") = " + upload_0$addAnnotation_1$preview_2.get(index).getCssValue("background-color"));
    }
}
