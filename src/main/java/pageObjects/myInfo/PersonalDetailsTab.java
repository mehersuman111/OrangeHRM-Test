package pageObjects.myInfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basePage.CommonPage;

public class PersonalDetailsTab extends CommonPage {

    @FindBy(linkText = "My Info")
    protected WebElement myInfoMenu;
    @FindBy(className = "employee-image")
    protected WebElement empProfilePic;
    @FindBy(linkText = "Personal Details")
    protected WebElement personalDetails;
    @FindBy(xpath = "//div[@class='orangehrm-edit-employee-name']//h6")
    protected WebElement empName;
    @FindBy(xpath = "(//div[@class='orangehrm-edit-employee-content']//h6)[1]")
    protected WebElement personalDetailsHeder;
    @FindBy(xpath = "(//div[@class='orangehrm-edit-employee-content']//h6)[2]")
    protected WebElement customerFieldsHeder;
    @FindBy(xpath = "(//div[@class='orangehrm-edit-employee-content']//h6)[3]")
    protected WebElement attachmentsHeader;
    @FindBy(css = "//label[text()='Employee Full Name']")
    protected WebElement empFullNamefn;
    @FindBy(name = "firstName")
    protected WebElement firstNameInpF;
    @FindBy(name = "middleName")
    protected WebElement middleNameInpF;
    @FindBy(name = "lastName")
    protected WebElement lastNameInpF;
    @FindBy(xpath = "//label[text()='Employee Id']")
    protected WebElement empIDfn;
    @FindBy(xpath = "//label[text()='Employee Id']/../..//input")
    protected WebElement empIDInpF;
    @FindBy(xpath = "//label[text()='Other Id']")
    protected WebElement othIDfn;
    @FindBy(xpath = "//label[text()='Other Id']/../..//input")
    protected WebElement otherIDInpF;
    @FindBy(xpath = "//label[starts-with(text(),'Dri')]")
    protected WebElement dlnoInpfn;
    @FindBy(xpath = "//label[starts-with(text(),'Dri')]/../..//input")
    protected WebElement dlnoInpF;
    @FindBy(xpath = "//label[starts-with(text(),'Lic')]")
    protected WebElement ledInpfn;
    @FindBy(xpath = "//label[starts-with(text(),'Lic')]/../..//input")
    protected WebElement ledInpF;
    @FindBy(xpath = "//label[text()='Nationality']")
    protected WebElement nationalityDDfn;
    @FindBy(xpath = "//label[text()='Nationality']/../../div[2]")
    protected WebElement nationalityDDf;


    public PersonalDetailsTab(WebDriver driver) {
        super(driver);
    }

}
