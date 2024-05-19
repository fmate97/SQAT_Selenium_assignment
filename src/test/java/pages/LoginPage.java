package pages;

import lib.BasePage;
import lib.DriverClass;
import lib.XPaths;

public class LoginPage extends BasePage {

    public LoginPage(DriverClass driver) {
        super(driver);
    }

    public String getSignIntoLabel() {
        return this.webElementGetText(XPaths.SignIntoLabel);
    }

    public void TryToLogin(String userName, String password) {
        this.textboxSendKeys(XPaths.EmailTextBox, userName);
        this.textboxSendKeys(XPaths.PasswordTextBox, password);
        this.buttonClick(XPaths.SignInButtonInLoginPage);
    }

    public Boolean isWrongEmailOrPassword() {
        return this.isDisplayed(XPaths.WrongEmailOrPasswordLabel);
    }
}
