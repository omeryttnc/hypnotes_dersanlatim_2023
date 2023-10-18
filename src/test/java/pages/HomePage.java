package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class HomePage extends CommonPage {

    public List<WebElement> listTitles = driver.findElements(By.cssSelector(".features-btn"));

    @FindBy(css = "h5[style]")
    public List<WebElement> listHeading;


}
