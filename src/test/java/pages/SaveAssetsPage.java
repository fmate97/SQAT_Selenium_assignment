package pages;

import lib.BasePage;
import lib.DriverClass;
import lib.XPaths;

public class SaveAssetsPage extends BasePage {

    public SaveAssetsPage(DriverClass driver) {
        super(driver);
    }

    public String getTitle(String expectedTitle) {
        return this.getPageTitle(expectedTitle);
    }

    public void CreateNewList(String name, String description) {
        this.buttonClick(XPaths.CreateNewListButton);

        this.textboxSendKeys(XPaths.ListNameTextboxOnCreate, name);
        this.textboxSendKeys(XPaths.ListDescriptionTextareaOnCreate, description);
        this.buttonClick(XPaths.PublicRadioButtonOnCreate);

        this.buttonClick(XPaths.SaveButton);
    }

    public Boolean isListCreated(String name) {
        String xpathSelector = "//div[text() = '" + name + "']";

        return this.webElementGetText(xpathSelector).contains(name);
    }

    public void OpenCreatedList(String name) {
        String xpathSelector = "//div[text() = '" + name + "']";
        this.buttonClick(xpathSelector);
    }
}
