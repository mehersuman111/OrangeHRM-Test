package pageObjects.logIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import pageObjects.basePage.CommonPage;

import java.util.List;

public class LogInPage extends CommonPage {

    @FindBy(xpath = "//textarea[@title='Search']")
    public WebElement searchBox;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div[2]/h5")
    protected WebElement pageName;
    @FindBy(xpath = "//img[@alt='company-branding']")
    protected WebElement companyBranding;
    @FindBy(xpath = "//img[@alt='company-logo']")
    protected WebElement companyLogo;
    @FindBy(name = "username")
    protected WebElement username;
    @FindBy(name = "password")
    protected WebElement password;
    @FindBy(xpath = "//button[normalize-space(text='Login')]")
    protected WebElement loginButton;
    @FindBy(linkText = "Forgot your password?")
    protected WebElement forgotPasswordLink;
    @FindBy(xpath = "//a[contains(@href,'https://')]")
    protected List<WebElement> companyLinks;

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LogInPage verifyAvailableDetailsInLoginPage () {

        return this;
    }

    // This is a factory method that returns an instance of the class.
    /*public static LogInPage init() {
        return new LogInPage(driver);
    }*/
}
