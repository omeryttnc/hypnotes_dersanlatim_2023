package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static stepDefinitions.Hooks.driver;

public class LoginPage extends CommonPage {
    @FindBy(css = "[data-test-id='loginAsClientPage_email']")
    public WebElement loginAsClientPage_email;
    @FindBy(css = "[data-test-id='loginAsClientPage_loginButton']")
    public WebElement loginAsClientPage_loginButton;

    @FindBy(xpath = "//input[@data-test-id='loginAsClientPage_password']")
    public WebElement loginAsClientPage_password;

    @FindBy(css = "[type='email']")
    public WebElement loginEmail;
  
    @FindBy(css = "[type='password']")
    public WebElement loginPassword;
  
    public void loginMethod(String userEmail,String userPassword){
        driver.get("https://test.hypnotes.net/login");
        loginAsClientPage_email.sendKeys(userEmail);
        loginAsClientPage_password.sendKeys(userPassword);
        loginAsClientPage_loginButton.click();
    }
}
