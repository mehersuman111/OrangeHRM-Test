package services.logIn;

import org.openqa.selenium.WebDriver;
import pageObjects.logIn.LogInPage;

public class LogInService extends LogInPage {

    public LogInService(WebDriver driver) {
        super(driver);
    }
    //LogInPage lp = new LogInPage(driver);
    public LogInService provideLoginCredential () {
                //lp.
        provideTextFieldValue(username, "username")
                .provideTextFieldValue(password, "password");
        return this;
    }
    public LogInService clickOnLoginBtn () {
        clickOnButton(loginButton, "Login");
        return this;
    }
}
