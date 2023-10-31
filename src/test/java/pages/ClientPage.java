package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class ClientPage extends CommonPage {
    @FindBy(css = "span.ant-menu-title-content [href$='clients']")
    public WebElement clients_sideBar;
    @FindBy(css = "[href$='add-client']")
    public WebElement addNewClient;
    @FindBy(css = ".text-center>h3")
    public WebElement addNewClient_text;

    @FindBy(id = "register_firstName")
    public WebElement register_firstName;

    @FindBy(id = "register_lastName")
    public WebElement register_lastName;

    @FindBy(css = "#register_email")
    public WebElement register_email;

    @FindBy(css = ".special-label + input")
    public WebElement register_phone;
   @FindBy(css = "div.ant-modal-confirm-content span")
    public WebElement cautionMessage;

    @FindBy(css = "div.ant-card-bordered")
    public List<WebElement> clientsInfoList;

    @FindBy(css = "[data-test-id='delet_button_clientsPage']")
    public List<WebElement> deleteButton;


    public ClientInfo getClientInfo(int index) { // chain locator
        BrowserUtilities.waitFor(2);
        String clientName = clientsInfoList.get(index).findElement(By.cssSelector("h5")).getText();
        String clientPhoneNumber = clientsInfoList.get(index).findElements(By.cssSelector("span.ant-typography-secondary")).get(0).getText();
        String clientEmail = clientsInfoList.get(index).findElements(By.cssSelector("span.ant-typography-secondary")).get(1).getText();
        String clientLocation = clientsInfoList.get(index).findElements(By.cssSelector("span.ant-typography-secondary")).get(2).getText();

        // ClientInfo clientInfo = new ClientInfo(clientName, clientPhoneNumber, clientEmail, clientLocation);

        return new ClientInfo(clientName, clientPhoneNumber, clientEmail, clientLocation);
    }

    public int getClientSize() {
        try {
            return clientsInfoList.size();
        } catch (NotFoundException e) {
            return 0;
        }

    }

    public record ClientInfo(String clientName, String clientPhoneNumber, String clientEmail, String clientLocation) {
    }

}
