package pages;


import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;


public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ServicesPage servicesPage;
    private ClientPage clientPage;
    private DocumentsPage documentsPage;
    private SettingsPage settingsPage;

    public DocumentsPage getDocumentsPage() {
        if (documentsPage == null) {
            documentsPage=new DocumentsPage();
        }
        return documentsPage;
    }

    public ClientPage getClientPage() {
        if (clientPage == null) {
            clientPage =new ClientPage();
        }
        return clientPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage= new LoginPage();
        }
        return loginPage;
    }

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
    public ServicesPage getServicesPage(){
        if(servicesPage==null){
            servicesPage= new ServicesPage();
        }
        return servicesPage;
    }
    public SettingsPage getSettingsPage(){
        if(settingsPage==null){
            settingsPage= new SettingsPage();
        }
        return settingsPage;
    }

}
