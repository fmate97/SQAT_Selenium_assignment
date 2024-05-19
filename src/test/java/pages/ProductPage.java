package pages;

import lib.BasePage;
import lib.DriverClass;
import lib.XPaths;

public class ProductPage extends BasePage {

    public ProductPage(DriverClass driver) {
        super(driver);
    }

    public Boolean productHasScreenshot(){
        return this.isDisplayed(XPaths.ScreenshotInProductPage);
    }
}
