package lib;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverClass {
    private WebDriver driver;
    private WebDriverWait wait;

    public DriverClass() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");

        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);

        wait = new WebDriverWait(driver, 10);
    }

    public void navigate(String url) {
        this.driver.get(url);
        this.wait.until(ExpectedConditions.urlContains(url));
    }

    public String getURL(String expectedURL) {
        this.wait.until(ExpectedConditions.urlContains(expectedURL));
        return this.driver.getCurrentUrl();
    }

    public void driverBack() {
        this.driver.navigate().back();
    }

    public String getPageTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        return this.driver.getTitle();
    }

    public void buttonClickWithJavascriptExecutor(String xpath) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        WebElement button = this.waitVisibilityAndFindElement(xpath);
        js.executeScript("arguments[0].click();", button);
    }

    public WebElement waitVisibilityAndFindElement(String xpath) {
        By locator = By.xpath(xpath);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void pageRefresh() {
        this.driver.navigate().refresh();
    }

    public void close() {
        driver.quit();
    }
}
