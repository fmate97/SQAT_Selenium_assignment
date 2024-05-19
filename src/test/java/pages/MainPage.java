package pages;

import lib.BasePage;
import lib.Config;
import lib.DriverClass;
import lib.XPaths;

public class MainPage extends BasePage {

    public MainPage(DriverClass driver) {
        super(driver);
    }

    public void openMainPage() {
        this.navigate(Config.url);
    }

    public String getTitle(String expectedTitle) {
        return this.getPageTitle(expectedTitle);
    }

    public void NavigateToLoginPage() {
        this.buttonClick(XPaths.UserProfileButton);
        this.buttonClick(XPaths.SignInButtonInUserProfile);
    }

    public void Category3DButtonClick() {
        this.buttonClick(XPaths.Category3DButton);
    }

    public void navigateToSettingsPage() {
        this.buttonClick(XPaths.UserProfileButton);
        this.buttonClick(XPaths.PersonalSettingsButton);
    }

    public void navigateToSaveAssetsPage() {
        this.buttonClick(XPaths.SaveAssetsButton);
    }
}
