package stepDefinitions;

import enums.COLOR;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manifold.ext.rt.api.This;
import org.junit.Assert;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import static stepDefinitions.Hooks.commonPage;

public class week1_us06 {
    @Then("assert first title color should be white")
    public void assertFirstTitleColorShouldBeWhite() {

        // 1. yontem
        // ctrl alt L ye basinca return turunden bir obje olusturmus oldum
        String actualTextColor = commonPage.getHomePage().listTitles.get(0).getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        Assert.assertEquals(expectedTextColor, actualTextColor);

        // 2. yontem enum
        COLOR.WHITE_TEXT.assertTextColor(commonPage.getHomePage().listTitles.get(0));

        // 3. configuration dan cagirarak
        String expectedTextColorFromConfiguration = ConfigurationReader.getProperty("WhiteColorText");
        Assert.assertEquals(expectedTextColorFromConfiguration, actualTextColor);

        // 4. yontem extension kullanimi
        commonPage.getHomePage().listTitles.get(0).assertTextColor(COLOR.WHITE_TEXT.getRGBA());

        // 5. yontem browser utilities
        BrowserUtilities.assertTextColor(commonPage.getHomePage().listTitles.get(0), COLOR.WHITE_TEXT.getRGBA());

    }

    @And("assert first title background color is green")
    public void assertFirstTitleBackgroundColorIsGreen() {
        // way 1 browser utilities
        BrowserUtilities.assertBackgroundColor(commonPage.getHomePage().listTitles.get(0), COLOR.TEXT_GREEN_BACKGROUND.getRGBA());

        // way 2 ENUM
        COLOR.TEXT_GREEN_BACKGROUND.assertBackgroundColor(commonPage.getHomePage().listTitles.get(0));
    }

    @When("user scroll to first title")
    public void userScrollToFirstTitle() {
        // 1 way browser utilities
        BrowserUtilities.scrollToWebElement(commonPage.getHomePage().listTitles.get(1));

        // 2 way extensions
        //  commonPage.getHomePage().listTitles.get(1).scrollToWebElement();

        // extension yontemi ile methodumuzu cagirdik
        commonPage.getHomePage().listTitles.get(1).hoverWebElement();
        BrowserUtilities.waitFor(2);

    }


    @Then("assert first title color should be black")
    public void assertFirstTitleColorShouldBeBlack() {
        COLOR.BLACK_TEXT.assertTextColor(commonPage.getHomePage().listTitles.get(0));
    }

    @And("assert first title background color is grey")
    public void assertFirstTitleBackgroundColorIsGrey() {
        COLOR.TEXT_GRAY_BACKGROUND.assertBackgroundColor(commonPage.getHomePage().listTitles.get(0));
    }
}
