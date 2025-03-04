package services.logIn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pageObjects.logIn.LogInPage;

public class LogInService extends LogInPage {

    public LogInService(WebDriver driver) {
        super(driver);
    }
    public LogInService verifyAvailableDetailsInLoginPage () {
        checkAvailableElement(companyBranding, "Company Branding")
                .checkAvailableElement(companyLogo, "Company Logo")
                .checkAvailableElement(username, "Username")
                .checkAvailableElement(password, "Password")
                .checkAvailableElement(loginButton, "Login Button")
                .checkAvailableElement(forgotPasswordLink, "Forgot Password Link")
                .checkAvailableElement(companyLinks, "Company Link", " ");
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
