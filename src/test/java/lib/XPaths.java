package lib;

public class XPaths {
    public static final String UserProfileButton = "//button[@data-test = 'avatar']";
    public static final String SignInButtonInUserProfile = "//div[text() = 'Sign In']/parent::div";

    public static final String SignIntoLabel = "//h2[text() = 'Sign into your Unity ID']";

    public static final String EmailTextBox = "//label[text() = 'Email']//parent::div//child::input";
    public static final String PasswordTextBox = "//label[text() = 'Password']//parent::div//child::input";
    public static final String SignInButtonInLoginPage = "//input[@data-disable-with = 'Sign in']";
    public static final String WrongEmailOrPasswordLabel = "//li[text() = 'The email and/or password you entered are incorrect. Please try again.']//ancestor::div[@class = 'error-msg']";

    public static final String Category3DButton = "//a[@href='/3d']";

    public static final String PersonalSettingsButton = "//div[text() = 'Personal Settings']";

    public static final String EditBIOButton = "//a[text() = 'Edit Bio']";
    public static final String TextArea = "//textarea";
    public static final String SaveButton = "//div[text()='Save']//parent::Button";
    public static final String BIOLabel = "//div[@data-reactid='135']";

    public static final String SignOutButton = "//div[text()='Sign Out']/parent::div";

    public static final String SaveAssetsButton = "//div[@data-reactid='40']//parent::button";
    public static final String CreateNewListButton = "//div[text() = 'Create new list']//parent::button";
    public static final String ListNameTextboxOnCreate = "//input[@type='text' and @placeholder='ex: My List of Magic Assets' ]";
    public static final String ListDescriptionTextareaOnCreate = "//div[contains(@class, 'description')]/child::textarea";
    public static final String PublicRadioButtonOnCreate = "//div[text() = 'Public']/parent::*/parent::*/child::button";

    public static final String SettingsButton = "//div[contains(@class, 'settings')]//parent::div";
    public static final String DeleteListButton = "//a[text() = 'Delete List']";
    public static final String ValidateDeleteButtonPress = "//button[contains(@label,'Yes')]";

    public static final String MyAssetsButton = "//div[@data-reactid='30']";

    public static final String ProductCardInMyAssetsPage = "//div[@class = '_2_Hn8 _3zauv']";

    public static final String ScreenshotInProductPage = "//img[@alt = 'screenshot']";
}