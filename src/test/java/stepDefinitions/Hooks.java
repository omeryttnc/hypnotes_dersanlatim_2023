package stepDefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.LoginPage;
import stepDefinitions.databaseStepDef.DatabaseMysql;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.DatabaseUtilities;
import utilities.Driver;


public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;
    public static Response response;
    public static String csrfToken;
    public static String PHPSESSID;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;
    public static Faker faker;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
        faker = new Faker();
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
//        Driver.closeDriver();
        driver.manage().deleteAllCookies();

    }


    @Before("@DB")
    public void setupDatabase() {
       DatabaseUtilities.getConnection();

    }

    @After("@DB")
    public void closeDatabase() {
        DatabaseUtilities.tearDatabase();
    }

    @Before("@user1")
    public void denemeLogin() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("user1_email") +
                        " password : " + ConfigurationReader.getProperty("user1_password")
        );


    }

    @After("@user1")
    public void denemeLogout() {
        System.out.println("log out");
    }


    @Before("@therapist")
    public void loginTherapist() {
        commonPage.getLoginPage().loginMethod(
                ConfigurationReader.getProperty("therapistEmail"),
                ConfigurationReader.getProperty("therapistPassword")
        );
        BrowserUtilities.waitFor(2);
        driver.navigate().refresh();
        BrowserUtilities.waitFor(2);
    }


}
