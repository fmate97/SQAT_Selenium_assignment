package pages;

import lib.BasePage;
import lib.DriverClass;
import lib.XPaths;

public class SettingsPage extends BasePage {

    public SettingsPage(DriverClass driver) {
        super(driver);
    }

    public void EditBIO(String text) {
        this.buttonClick(XPaths.EditBIOButton);
        this.textboxSendKeys(XPaths.TextArea, text);
        this.buttonClick(XPaths.SaveButton);
    }

    public String GetBIOText() {
        return this.webElementGetText(XPaths.BIOLabel);
    }

    public void SignOut() {
        this.buttonClick(XPaths.UserProfileButton);
        this.buttonClick(XPaths.SignOutButton);
    }
}
