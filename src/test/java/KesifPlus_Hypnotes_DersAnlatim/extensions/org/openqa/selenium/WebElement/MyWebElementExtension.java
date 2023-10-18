package KesifPlus_Hypnotes_DersAnlatim.extensions.org.openqa.selenium.WebElement;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

@Extension
public class MyWebElementExtension {

  public static void assertTextColor(@This WebElement element, String expectedColor){

    String actualTextColor=  element.getCssValue("color");

    Assert.assertEquals(expectedColor,actualTextColor);
  }

  public static void scrollToWebElement(@This WebElement webElement){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",webElement);
  }
  public static void hoverWebElement(@This WebElement webElement){
//        Actions actions = new Actions(driver);
    actions.moveToElement(webElement).build().perform();
  }

  public static WebElement waitForVisibility(@This WebElement webElement){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOf(webElement));
  }
}