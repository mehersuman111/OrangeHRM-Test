package services.starterHelp;

import org.openqa.selenium.WebDriver;
import pageObjects.starterHelp.StarterHelpTab;

public class StarterHelpService extends StarterHelpTab {

    public StarterHelpService(WebDriver driver) {
        super(driver);
    }

    public StarterHelpService navigateToStarterHelpTab() {
        clickOnButton(starterHelpButton, "Starter Help Button")
                .switchToDesireTab("Starter Help")
                .checkAppearanceOfElement(mainContent, "Main Content");
        return this;
    }

    public StarterHelpService verifyAvailableDetailsInStarterHelpTab() {
        checkAvailableElement(searchBox, "Search Box")
                .checkAvailableElement(helpTopics, "Help Topics", " ")
                .checkAvailableElement(orangeHRMHelpLink, "OrangeHRM Help Link", " ")
                .checkAvailableElement(helpSignInLink, "Help Sign In Link", " ");
        return this;
    }
}
