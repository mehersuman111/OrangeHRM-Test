package services.logIn;

import framework.browserCofig.TestInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pageObjects.logIn.LogInPage;
import services.dashboard.DashboardService;

public class LogInService extends LogInPage {

    private static LogInService logInService;
    //Constructor
    public LogInService(WebDriver driver) {
        super(driver);
    }
    public static LogInService getLogInService() {
        if (logInService == null) {
            logInService = new LogInService(TestInit.driver);
        }
        return logInService;
    }
    public LogInService verifyAvailableDetailsInLoginPage () {
        checkAvailableElement(companyBranding, "Company Branding")
                .checkAvailableElement(companyLogo, "Company Logo")
                .checkAvailableElement(username, "Username")
                .checkAvailableElement(password, "Password")
                .checkAvailableElement(loginButton, "Login Button")
                .checkAvailableElement(forgotPasswordLink, "Forgot Password Link")
                .checkAvailableElement(companyLinks, "Company Link", " ")
                .verifyTextElement(pageName,"Login");
        return this;
    }
    public LogInService provideLoginCredential (String uNameVal, String pwdVal) {
        provideTextFieldValue(username, uNameVal)
                .provideTextFieldValue(password, pwdVal);
        return this;
    }
    public LogInService clickOnLoginBtn () {
        clickOnButton(loginButton, "Login");
        return this;
    }

}
