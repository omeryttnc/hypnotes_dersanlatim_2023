package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;
import java.util.List;
import static stepDefinitions.Hooks.driver;

public class HomePage extends CommonPage {

    public List<WebElement> listTitles = driver.findElements(By.cssSelector(".features-btn"));

    @FindBy(css = "h5[style]")
    public List<WebElement> listHeading;

    @FindBy(css = "span.ant-menu-title-content")
    public List<WebElement> navbarList;

    @FindBy(css = ".swiper-pagination-bullet")
    public List<WebElement> bulletPoints;

    @FindBy(css = "div.ant-message-custom-content span")
    private List<WebElement> alertMessage;

    @FindBy(css = "div.swiper-button-next")
    private WebElement nextButton;


    public void clickNextButton(){
        BrowserUtilities.scrollAndClickWebElement(nextButton);

    }

    public void assertAlertMessage(String expectedAlertMessage){

        BrowserUtilities.waitForVisibility(alertMessage.get(1));
        String actualAlertMessage = alertMessage.get(1).getText();
        Assert.assertEquals(expectedAlertMessage,actualAlertMessage);
    }
}
