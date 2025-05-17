package webTest.admin.userManagement;

import framework.browserCofig.TestInit;
import org.testng.annotations.Test;


public class UserManagementTest extends TestInit{
    @Test(priority = 1)
    public void UI_UserManagement_01_Verify_UserManagement_Screen() throws InterruptedException {
        userManagementService.verifyAvailableDetailsInUserManagementPage();
        System.out.println("To verify all available details in the user management page");
    }
    @Test(priority = 2)
    public void UI_UserManagement_02_Verify_Available_Options() throws InterruptedException {
        userManagementService.verifyAvailableOptionsWithUserManagement();
        System.out.println("To verify all available options in the user management dropdown menu");
    }
}