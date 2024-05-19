package pages;

import lib.BasePage;
import lib.DriverClass;
import lib.XPaths;

public class MyAssetsPage extends BasePage {

    public MyAssetsPage(DriverClass driver) {
        super(driver);
    }

    public void OpenMyAssetsPage() {
        this.buttonClick(XPaths.MyAssetsButton);
    }

    public void OpenProductPage() {
        this.buttonClickWithJavascriptExecutor(XPaths.ProductCardInMyAssetsPage);
    }
}
