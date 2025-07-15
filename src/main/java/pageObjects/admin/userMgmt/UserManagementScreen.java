package pageObjects.admin.userMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.basePage.CommonPage;

import java.util.List;

public class UserManagementScreen extends CommonPage {

    @FindBy(xpath = "//span[text()='User Management ']/..")
    protected WebElement userMgmtMenu;
    @FindBy(xpath = "//h5[text()='System Users']")
    protected WebElement systemUsersHeader;
    @FindBy(xpath="//label[text()='Username']/../..//input")
    public WebElement userNameTxtField;
    @FindBy(css = "div.oxd-select-wrapper")
    protected List<WebElement> selectDropdowns;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    protected WebElement employeeNameTF;
    // Need to implement normalize space xpath function
    @FindBy(xpath = "//button[text()=' Reset ']")
    protected WebElement resetButton;
    @FindBy(xpath = "//button[text()=' Search ']")
    protected WebElement searchButton;
    @FindBy(xpath = "//span[text()='No Records Found']")
    public WebElement noResult;

    public UserManagementScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
