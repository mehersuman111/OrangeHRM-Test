package pageObjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.basePage.CommonPage;

import java.util.List;

public class DashboardScreen extends CommonPage {

    @FindBy(xpath = "//h6[text()='Dashboard']")
    protected WebElement dashboardHeader;
    @FindBy(css = "a.orangehrm-upgrade-link")
    protected WebElement upgradeButton;
    @FindBy(css = "li.oxd-userdropdown")
    protected WebElement userDropdown;
    @FindBy(xpath = "//button[@title='Help']")
    protected WebElement helpButton;
    @FindBy(xpath = "//ul/li/a/span")
    protected List<WebElement> dashboardMenu;
    @FindBy(css = "button.oxd-main-menu-button")
    protected WebElement menuArrowButton;
    @FindBy(css = "div.oxd-brand-banner")
    protected WebElement brandBanner;

    public DashboardScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}