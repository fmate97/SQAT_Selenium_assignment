package pages;

import lib.BasePage;
import lib.DriverClass;

public class CategorySearchPage extends BasePage {

    public CategorySearchPage(DriverClass driver) {
        super(driver);
    }

    public void browserGoBack() {
        this.driver.driverBack();
    }
}
