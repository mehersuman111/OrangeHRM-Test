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
    @FindBy(xpath = "//div[@class='orangehrm-header-container']//button")
    public WebElement addUserBtn;
    @FindBy(xpath = "//h6[text()='Add User']")
    public WebElement addUserHeader;
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
    public WebElement userRoleDD;
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]")
    public WebElement statusDD;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement empNameTF;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus oxd-input--error']")
    public WebElement userNameTF;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus oxd-input--error']")
    public WebElement passwordTF;
    public UserManagementScreen(WebDriver driver) {
        super(driver);
    }
}
