package webTest.admin.userManagement;

import framework.browserCofig.TestInit;
import framework.listenerActions.RetryAnalyzer;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pageObjects.admin.userMgmt.UserManagementScreen;
import testData.RandomData;


public class UserManagementTest extends TestInit{
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    @Description("To verify all available details in the User Management screen.")
    @Epic("EPIC001")
    @Feature("Feature 2: User Management")
    @Story("Story 1: User Management screen elements")
    @Step("Verify User Management screen")
    //@Severity(SeverityLevel.MINOR)
    public void UI_UserManagement_01_Verify_UserManagement_Screen() throws InterruptedException {
        logger.info("Verifying all available elements in the User Management screen.");
        userManagementService.verifyAvailableDetailsInUserManagementPage();
    }
    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void UI_UserManagement_02_Verify_Available_Options() throws InterruptedException {
        logger.info("To verify all available options in the user management dropdown menu");
        userManagementService.verifyAvailableOptionsWithUserManagement();
    }
    @Test(priority = 3, enabled = true)
    public void UI_UserManagement_03_Search_An_Existing_UserName() {
        userManagementService.provideUserName("Admin")
                        .clickOnSearchButton().getUserSearchData()
                .validateFetchedUser("UserName",//ums.userNameTxtField.getText()
                        "Admin");
    }
    @Test(priority = 4, enabled = true)
    public void UI_UserManagement_04_Search_A_NonExisting_UserName() {
        userManagementService.provideUserName(RandomData.generateRandomString(8))
                .clickOnSearchButton()
                .getUserSearchData();
        //ums.noResult
    }
    @Test(priority = 5, enabled = true)
    public void UI_UserManagement_05_Verify_Add_User_screen() {
        userManagementService.clickOnAddUserBtn()
                .verifyAddUserForm();
    }
    @Test(priority = 6, enabled = true)
    public void UI_UserManagement_06_Verify_Options_In_UserRole_DD() {
        userManagementService.clickOnButton(userManagementService.userRoleDD, "User role dropdown field");
                //.checkAppearanceOfElement();
    }
}