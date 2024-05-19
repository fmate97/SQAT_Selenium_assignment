package pages;

import lib.BasePage;
import lib.DriverClass;
import lib.XPaths;

public class OwnListPage extends BasePage {

    public OwnListPage(DriverClass driver) {
        super(driver);
    }

    public String getTitle(String expectedTitle) {
        return this.getPageTitle(expectedTitle);
    }

    public void deleteCreatedList() {
        this.buttonClick(XPaths.SettingsButton);
        this.buttonClick(XPaths.DeleteListButton);
        this.buttonClick(XPaths.ValidateDeleteButtonPress);
    }
}
