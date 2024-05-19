package lib;

import org.openqa.selenium.WebElement;

public class BasePage {
    protected DriverClass driver;

    protected BasePage(DriverClass driver) {
        this.driver = driver;
    }

    protected DriverClass getDriverClass() {
        return this.driver;
    }

    protected void navigate(String url) {
        this.driver.navigate(url);
    }

    protected String getPageTitle(String expectedTitle) {
        return this.driver.getPageTitle(expectedTitle);
    }

    public String getActualURL(String expectedURL) {
        return this.driver.getURL(expectedURL);
    }

    protected String webElementGetText(String webElementXPath) {
        return this.driver.waitVisibilityAndFindElement(webElementXPath).getText();
    }

    protected void textboxSendKeys(String textboxXPath, String keys) {
        WebElement textbox = this.driver.waitVisibilityAndFindElement(textboxXPath);
        textbox.clear();
        textbox.sendKeys(keys);
    }

    protected void buttonClick(String buttonXPath) {
        this.driver.waitVisibilityAndFindElement(buttonXPath).click();
    }

    protected void buttonClickWithJavascriptExecutor(String buttonXPath) {
        this.driver.buttonClickWithJavascriptExecutor(buttonXPath);
    }

    protected Boolean isDisplayed(String webElementXPath) {
        return this.driver.waitVisibilityAndFindElement(webElementXPath).isDisplayed();
    }

    public void pageRefresh() {
        this.driver.pageRefresh();
    }

    protected void browserBack() {
        this.driver.driverBack();
    }

    public void driverClose() {
        this.driver.close();
    }
}
