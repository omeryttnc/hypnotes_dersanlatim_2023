package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class HomePage extends CommonPage {

   // public List<WebElement> listTitles = driver.findElements(By.cssSelector(".features-btn"));

    @FindBy(css = ".features-btn")
    public List<WebElement> listTitles;

    @FindBy(css = "h5[style]")
    public List<WebElement> listHeading;

    @FindBy(css = "span.ant-menu-title-content")
    public List<WebElement> navbarList;

    @FindBy(css = ".swiper-pagination-bullet")
    public List<WebElement> bulletPoints;

    @FindBy(css = "div.ant-message-custom-content")
    private WebElement alertMessage;

    @FindBy(css = "div.swiper-button-next")
    private WebElement nextButton;
    @FindBy(xpath = "//span[@class='ant-select-selection-item']")
    public WebElement languageFlagButton;
    @FindBy(xpath = "//div[@class='style_first__DOtRH']")
    public WebElement finallyText;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    public List<WebElement> languageFlagList;

    @FindBy(xpath = "//span[@data-test-id= 'loginScreen_logIn']")
    public WebElement login;

    @FindBy(css = ".ant-menu-title-content a[href$='/documents']")
    public WebElement side_documents;

    public void clickNextButton() {
        BrowserUtilities.scrollAndClickWebElement(nextButton);
    }

    public void assertAlertMessage(String expectedAlertMessage) {
        System.out.println("alertMessage.getText() = " + alertMessage.getText());
        BrowserUtilities.waitFor(1);
        BrowserUtilities.waitForVisibility(alertMessage);
        String actualAlertMessage = alertMessage.getText();
        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
    }
}
