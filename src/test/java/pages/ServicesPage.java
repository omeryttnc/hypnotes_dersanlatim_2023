package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicesPage extends  CommonPage{
    @FindBy(xpath = "//*[@data-test-id='new_individualForm_name']")
    public WebElement nameBoxIndividual;
    @FindBy(xpath = "//*[@data-test-id='new_individualForm_price']//input")
    public WebElement priceBoxIndividual;
    @FindBy(xpath = "//*[@data-test-id='new_individualForm_duration']//input")
    public WebElement durationBoxIndividual;
    @FindBy(xpath = "//*[@data-test-id='new_individualForm_blockBefore']//input")
    public WebElement blockBeforeBoxIndividual;
    @FindBy(xpath = "//*[@data-test-id='new_individualForm_blockAfter']//input")
    public WebElement blockAfterBoxIndividual;
    @FindBy(xpath = "//*[contains(@class,'ant-tabs-tabpane-active')]//span[contains(text(),'Save')]")
    public WebElement saveButtonIndividual;

    @FindBy(xpath = "//div[@class='ant-form-item-explain-error']")
    public WebElement errorMessage;
    @FindBy(xpath = "//*[@class='ant-menu-title-content']//a[@href='/dashboard/services']")
    public WebElement servicesTab;

    @FindBy(xpath = "//*[contains(@class,'ant-tabs-tabpane-active')]//*[contains(@class,'ant-tabs-tabpane-active')]//*[text()='Add New Individual Session']")
    public WebElement addNewIndividualSession;




}
