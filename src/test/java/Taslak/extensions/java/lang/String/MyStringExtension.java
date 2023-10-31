package Taslak.extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;

import static stepDefinitions.Hooks.driver;

@Extension
public class MyStringExtension {
    public static void helloWorld(@This String thiz) {
        System.out.println("hello world!");
    }

    public static String addGmail(@This String thiz) {
        return thiz + "@gmail.com";
    }
    public static void isLongerThan(@This String thiz,int expectedLength){
        Assert.assertTrue("beklenen uzunlugumuz : " +expectedLength+", gercek uzunluk : " + thiz.length(),thiz.length()>expectedLength);
    }
    public static void clickWebElementByText(@This String text){
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        BrowserUtilities.waitForVisibility(element);
        element.click();

    }

}