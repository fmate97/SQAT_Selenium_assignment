import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import lib.Config;
import lib.DriverClass;
import lib.TestOrder;
import lib.TestOrderEnum;
import pages.CategorySearchPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAssetsPage;
import pages.OwnListPage;
import pages.ProductPage;
import pages.SaveAssetsPage;
import pages.SettingsPage;

public class TestRunner {
    private static DriverClass driver;

    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static CategorySearchPage categorySearchPage;
    private static SettingsPage settingsPage;
    private static SaveAssetsPage saveAssetsPage;
    private static OwnListPage ownListPage;
    private static MyAssetsPage myAssetsPage;
    private static ProductPage productPage;

    @BeforeClass
    public static void startTesting() throws MalformedURLException {
        driver = new DriverClass();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        categorySearchPage = new CategorySearchPage(driver);
        settingsPage = new SettingsPage(driver);
        saveAssetsPage = new SaveAssetsPage(driver);
        ownListPage = new OwnListPage(driver);
        myAssetsPage = new MyAssetsPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testRunner() throws IOException {
        for (TestOrderEnum nextTest : new TestOrder().getTestOrder()) {
            executeTest(nextTest);
        }
    }

    @AfterClass
    public static void endTesting() {
        mainPage.driverClose();
    }

    private void executeTest(TestOrderEnum nextTest) {
        switch (nextTest) {
            case SUCCESSFUL_OPEN_MAIN_PAGE:
                this.successfulOpenMainPage();
                break;
            case SUCCESSFUL_OPEN_LOGIN_PAGE:
                this.successfulOpenLoginPage();
                break;
            case FAILED_LOGIN:
                this.failedLogin();
                break;
            case SUCCESSFUL_LOGIN:
                this.successfulLogin();
                break;
            case CLICK_3D_CATEGORY:
                this.click3DCategory();
                break;
            case BROWSER_BACK:
                this.browserBack();
                break;
            case NAVIGATE_TO_SETTINGS_PAGE:
                this.navigateToSettingsPage();
                break;
            case EDIT_BIO:
                this.editBIO();
                break;
            case SIGN_OUT:
                this.signOut();
                break;
            case SUCCESSFUL_OPEN_SAVE_ASSETS_PAGE:
                this.openSaveAssetsPage();
                break;
            case CREATE_NEW_LIST_IN_SAVE_ASSETS_PAGE:
                this.createNewListInSaveAssetsPage();
                break;
            case SELECT_CREATED_LIST_IN_SAVE_ASSETS_PAGE:
                this.selectCreatedListInSaveAssetsPage();
                break;
            case DELETE_CREATED_LIST_IN_OWN_LIST_PAGE:
                this.deleteCreatedListInOwnListPage();
                break;
            case SUCCESSFUL_OPEN_MY_ASSETS_PAGE:
                this.successfulOpenMyAssetsPage();
                break;
            case SUCCESSFUL_OPEN_PRODUCT_PAGE:
                this.successfulOpenProductPage();
                break;
            case NAVIGATE_TO_MAIN_PAGE_FROM_PRODUCT_PAGE:
                this.navigateToMainPageFromProductPage();
                break;
            default:
                throw new IllegalArgumentException("Invalid test name: " + nextTest);
        }
    }

    private void successfulOpenMainPage() {
        mainPage.openMainPage();
        Assert.assertTrue(mainPage.getTitle(Config.mainPageTitle).contains(Config.mainPageTitle));
    }

    private void successfulOpenLoginPage() {
        mainPage.NavigateToLoginPage();
        Assert.assertTrue(loginPage.getSignIntoLabel().contains(Config.signIntoLabel));
    }

    private void failedLogin() {
        loginPage.TryToLogin(Config.username + "1", Config.password + "6");
        Assert.assertTrue(loginPage.isWrongEmailOrPassword());
    }

    private void successfulLogin() {
        loginPage.TryToLogin(Config.username, Config.password);
        Assert.assertTrue(mainPage.getTitle(Config.mainPageTitle).contains(Config.mainPageTitle));
    }

    private void click3DCategory() {
        mainPage.Category3DButtonClick();
        Assert.assertTrue(mainPage.getActualURL("3d").contains("3d"));
    }

    private void browserBack() {
        categorySearchPage.browserGoBack();
        Assert.assertTrue(mainPage.getTitle(Config.mainPageTitle).contains(Config.mainPageTitle));
    }

    private void navigateToSettingsPage() {
        mainPage.navigateToSettingsPage();
        Assert.assertTrue(settingsPage.getActualURL("account/settings").contains("account/settings"));
    }

    private void editBIO() {
        String randomText = getRandomText(25);
        settingsPage.EditBIO(randomText);
        settingsPage.pageRefresh();
        Assert.assertTrue(settingsPage.GetBIOText().contains(randomText));
    }

    @SuppressWarnings("static-access")
    private void signOut() {
        settingsPage.SignOut();

        Assert.assertTrue(mainPage.getTitle(Config.mainPageTitle).contains(Config.mainPageTitle));

        settingsPage.driverClose();
        try {
            this.startTesting();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private String getRandomText(Integer length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    private void openSaveAssetsPage() {
        mainPage.navigateToSaveAssetsPage();
        Assert.assertTrue(saveAssetsPage.getTitle(Config.savedAssetsPageTitel).contains(Config.savedAssetsPageTitel));
    }

    private String createdListName = null;
    private void createNewListInSaveAssetsPage() {
        createdListName = this.getRandomText(10);

        saveAssetsPage.CreateNewList(createdListName, this.getRandomText(25));

        Assert.assertTrue(saveAssetsPage.isListCreated(createdListName));
    }

    private void selectCreatedListInSaveAssetsPage() {
        saveAssetsPage.OpenCreatedList(createdListName);
        Assert.assertTrue(ownListPage.getTitle(createdListName).contains(createdListName));
    }

    private void deleteCreatedListInOwnListPage() {
        ownListPage.deleteCreatedList();
        Assert.assertTrue(saveAssetsPage.getActualURL("account/lists").contains("account/lists"));
        createdListName = null;
    }

    private void successfulOpenMyAssetsPage() {
        myAssetsPage.OpenMyAssetsPage();
        Assert.assertTrue(myAssetsPage.getActualURL("account/assets").contains("account/assets"));
    }

    private void successfulOpenProductPage() {
        myAssetsPage.OpenProductPage();
        Assert.assertTrue(productPage.getActualURL("packages").contains("packages"));
    }

    private void navigateToMainPageFromProductPage() {
        productPage.NavigateMainPage();
        Assert.assertTrue(mainPage.getTitle(Config.mainPageTitle).contains(Config.mainPageTitle));
    }
}
