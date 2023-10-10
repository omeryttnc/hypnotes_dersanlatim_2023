package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;


public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;
    private RegisterPage registerPage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public RegisterPage getRegisterPage(){
        if(registerPage==null){
            registerPage= new RegisterPage();
        }
        return registerPage;
    }

}
