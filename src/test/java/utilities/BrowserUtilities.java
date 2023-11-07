package utilities;


import com.github.javafaker.Faker;
import com.google.common.io.Files;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class BrowserUtilities {
    public static String addHotmail(String name) {

        String email = "ss";

        return name + "@hotmail.com";
    }

    public static void assertTextColor(WebElement element, String expectedColor) {

        String actualTextColor = element.getCssValue("color");

        Assert.assertEquals(expectedColor, actualTextColor);
    }

    public static void assertBackgroundColor(WebElement element, String expectedColor) {

        String actualTextColor = element.getCssValue("background-color");

        Assert.assertEquals(expectedColor, actualTextColor);
    }

    public static void scrollToWebElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitForVisibility(webElement);
    }

    public static void scrollAndClickWebElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }


    public static void hoverWebElement(WebElement webElement) {
//        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();


    }

    public static String getScrollWidth(WebElement webElement) {
        return webElement.getAttribute("scrollWidth");
    }

    public static WebElement waitForVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method is used to get validation message property
     *
     * @param webElement is the element we used to get property
     * @return validation message of Webelement
     * @author omer
     * @since 24.10.2023
     */
    public static String getValidationMessage(WebElement webElement) {
        return webElement.getAttribute("validationMessage");
    }


    /**
     * webelment icindeki bilgiyi siliyor
     *
     * @param webElement icerigi silinecek webelement
     *                   <p>
     *                   not: eger clear methodu calismazsa bunu kullanabilirsin
     */
    public static void clearWebelement(WebElement webElement) {
        int lengthOfWeblement = webElement.getAttribute("value").length();

        for (int j = 0; j < lengthOfWeblement; j++) {
            actions.sendKeys(Keys.BACK_SPACE).perform();
        }
    }

    public static WebElement getWebElementByUsingText(String text) {
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
    }

    /**
     * ne islem yapiyor
     * girdisi nedir
     * ciktisi nedir
     * @param color
     * @param webElement
     */
    public static void assertBackgroundColour(String color,WebElement webElement) {
        Assert.assertEquals(color, webElement.getCssValue("background-color"));
    }

    public static String removeSpecialCharacters(String str){
        return str;
    }
    public static String removeSpecialCharactersExceptFullStop(String str){
        return str;
    }

    public static String createFakeFile() {
        Faker faker = new Faker();
        String fakeFileName = faker.name().firstName() + ".pdf";

        String oldFile = System.getProperty("user.dir") + "\\src\\test\\resources\\KesifPlusPdfSample.pdf";
        String newFile = System.getProperty("user.dir") + "\\target\\" + fakeFileName;

        File fileEski = new File(oldFile);
        File fileYeni = new File(newFile);

        try {
            Files.copy(fileEski, fileYeni);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fakeFileName;
    }

    public static String getFakeFilePath(String fileName){
        String newFile = System.getProperty("user.dir") + "\\target\\" + fileName;
        return newFile;

    }
}
