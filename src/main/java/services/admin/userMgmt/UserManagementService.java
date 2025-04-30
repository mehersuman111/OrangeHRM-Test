package services.admin.userMgmt;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.userMgmt.UserManagementScreen;
import testData.AdminData;

public class UserManagementService extends UserManagementScreen implements AdminData {
    public UserManagementService(WebDriver driver) {
        super(driver);
    }

    public UserManagementService verifyAvailableDetailsInUserManagementPage() throws InterruptedException {
        selectAMenu("Admin","Active")
                .checkAvailableElement(systemUsersHeader,"System Users",3);
        return this;
    }
    public UserManagementService verifyAvailableOptionsWithUserManagement() throws InterruptedException {
        verifyAvailableDropdownOptions(userMgmtMenu,AdminData.userMgmtMenuOptions,1);
        return this;
    }
    public UserManagementService searchUser() {
        //provideTextFieldValue();
        return this;
    }

}
