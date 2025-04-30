package pageObjects.admin.userMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.basePage.CommonPage;

public class UserManagementScreen extends CommonPage {

    @FindBy(xpath = "//span[text()='User Management ']/..")
    protected WebElement userMgmtMenu;
    @FindBy(xpath = "//h5[text()='System Users']")
    protected WebElement systemUsersHeader;
    @FindBy(xpath="//label[text()='Username']/../..//input")
    protected WebElement userNameTxtField;


    public UserManagementScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
