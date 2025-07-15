package pageObjects.pim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basePage.CommonPage;

public class EmployeeList extends CommonPage {

    @FindBy(xpath = "//label[text()='Employee Name']")
    protected WebElement empNameTFLabel;
    @FindBy(xpath = "//label[text()='Employee Name']/../..//input")
    protected WebElement empNameTF;
    @FindBy(xpath = "//label[text()='Employee Id']")
    protected WebElement empIdLabel;
    @FindBy(xpath = "//label[text()='Employee Id']/../..//input")
    protected WebElement empIdTF;
    @FindBy(xpath = "//label[text()='Employment Status']")
    protected WebElement empStatusDDFLabel;
    @FindBy(xpath = "//label[text()='Employment Status']/../../div[2]/div/div")
    protected WebElement empStatusDDF;
    @FindBy(xpath = "//label[text()='Include']")
    protected WebElement curEmpDDFLabel;
    @FindBy(xpath = "//label[text()='Include']/../../../div/div[2]/div")
    protected WebElement curEmpDDF;
    @FindBy(xpath = "//label[text()='Supervisor Name']")
    protected WebElement getSupervisorNameDDFLabel;
    @FindBy(xpath = "//label[text()='Supervisor Name']/../../../div/div[2]/div")
    protected WebElement supervisorNameDDF;
    @FindBy(xpath = "//label[text()='Job Title']")
    protected WebElement getJobTitleDDFLabel;
    @FindBy(xpath = "//label[text()='Job Title']/../../../div/div[2]/div")
    protected WebElement jobTitleDDF;
    @FindBy(xpath = "//label[text()='Sub Unit']")
    protected WebElement getSubUnitDDFLabel;
    @FindBy(xpath = "//label[text()='Sub Unit']/../../../div/div[2]/div")
    protected WebElement subUnitDDF;



    public EmployeeList(WebDriver driver) {
        super(driver);
    }
}
