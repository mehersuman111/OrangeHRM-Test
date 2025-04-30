package webTest.starterHelp;

import framework.browserCofig.TestInit;
import org.testng.annotations.Test;

public class StarterHelpTest extends TestInit {
    @Test(priority = 1)
    public void UI_Starter_Help_01_Open_StarterHelp_Tab() {
        starterHelpService.navigateToStarterHelpTab();
    }
    @Test(priority = 2,dependsOnMethods = "UI_Starter_Help_01_Open_StarterHelp_Tab")
    public void UI_Starter_Help_02_Verify_Starter_Help_Screen() {
        starterHelpService.verifyAvailableDetailsInStarterHelpTab();
    }
}
