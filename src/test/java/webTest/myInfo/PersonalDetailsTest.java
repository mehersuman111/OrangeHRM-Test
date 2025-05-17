package webTest.myInfo;

import framework.browserCofig.TestInit;
import org.testng.annotations.Test;

public class PersonalDetailsTest extends TestInit {
    @Test(priority = 1)
    public void UI_Starter_Help_01_VerifyByNavigatingToPersonDetailsTab() {
        logger.info("Executing the first testcase");
        personalDetailsService.NavigateToPersonalDetailsTab();
    }
    @Test(priority = 2)
    public void UI_Starter_Help_0w_GetAvailableOptionInNationality() {
        personalDetailsService.checkNationalityOptions();
    }
}