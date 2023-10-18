package utilities;


import manifold.ext.rt.api.This;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            Thread.sleep(sec *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
