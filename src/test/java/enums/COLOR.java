package enums;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public enum COLOR {
    BLACK_TEXT("#000000","rgb(0, 0, 0)","rgba(0, 0, 0, 1)"),
    WHITE_TEXT("#ffffff","rgb(255, 255, 255)","rgba(255, 255, 255, 1)"),
    TEXT_GRAY_BACKGROUND("#cccece","rgb(204, 206, 206)","rgba(204, 206, 206, 1)"),
    TEXT_GREEN_BACKGROUND("#007385", "rgb(0, 115, 133)","rgba(0, 115, 133, 1)")
    ;

    COLOR(String HEX, String RBG, String RGBA) {
        this.HEX = HEX;
        this.RBG = RBG;
        this.RGBA = RGBA;
    }

    private String HEX;
    private String RBG;
    private String RGBA;

    public String getHEX() {
        return HEX;
    }

    public String getRBG() {
        return RBG;
    }

    public String getRGBA() {
        return RGBA;
    }

    public void assertTextColor(WebElement element){

      String actualTextColor=  element.getCssValue("color");

        Assert.assertEquals(this.getRGBA(),actualTextColor);


    }
    public void assertBackgroundColor(WebElement element){

      String actualBackgroundColor=  element.getCssValue("background-color");

        Assert.assertEquals(this.getRGBA(),actualBackgroundColor);


    }
}
