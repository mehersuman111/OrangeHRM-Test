package webTest.LoginMgmt;

import framework.browserCofig.TestInit;
import framework.annotations.TestCategory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.TestCases;

public class LoginTest extends TestInit {
    @DataProvider(name = "loginCredentials",indices = {4})
    Object[][] loginCredentialData() {
        Object data[][] = {
                {"admin", "admin@123"},
                {"agent", "agent@123"},
                {"user", "user@123"},
                {"manager", "manager@123"},
                {properties.getProperty("username"), properties.getProperty("password")}
        };
        return data;
    }
    // Testcase to verify the available details in the login page
    @Test(priority = 1, groups = {"regression"}, description = TestCases.tc_UI_0001)
    @TestCategory("Regression")
    public void UI_Web_01_Test_Login_Page() {
        ls.verifyAvailableDetailsInLoginPage();
    }
    // Test case to validate login functionality
    @Test(dataProvider = "loginCredentials", priority = 2, groups = {"smoke"}, description = TestCases.tc_UI_0002)
    public void UI_Web_02_Test_Login(String username, String password) {
        ls.provideLoginCredential(username, password)
                .clickOnLoginBtn();
    }
}