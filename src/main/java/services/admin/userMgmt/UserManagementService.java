package services.admin.userMgmt;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.admin.userMgmt.UserManagementScreen;
import testData.AdminData;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagementService extends UserManagementScreen implements AdminData {
    private Logger logger = LogManager.getLogger(this.getClass());
    List<HashMap> tableData = new ArrayList<HashMap>();
    public UserManagementService(WebDriver driver) {
        super(driver);
    }

    public UserManagementService verifyAvailableDetailsInUserManagementPage() throws InterruptedException {
        selectAMenu("Admin","Active")
                .letPanelArrowButtonClick("left","right")
                .checkAvailableElement(systemUsersHeader,"System Users",2);
        return this;
    }
    public UserManagementService verifyAvailableOptionsWithUserManagement() throws InterruptedException {
        verifyAvailableDropdownOptions(selectDropdowns.get(0),AdminData.userMgmtRoleOptions,2)
                .verifyAvailableDropdownOptions(selectDropdowns.get(1),AdminData.userMgmtStatusOptions,3);
        return this;
    }
    public UserManagementService provideUserName(String userNameV) {
        provideTextFieldValue(userNameTxtField, userNameV);
        return this;
    }
    public UserManagementService clickOnSearchButton() {
        logger.info("Clicking on the search button.");
        searchButton.click();
        return this;
    }
    public UserManagementService clickOnResetButton() {
        logger.info("Clicking on the reset button.");
        resetButton.click();
        return this;
    }
    public UserManagementService getUserSearchData() {
        logger.info("Verifying the searched user.");
        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div[@role='row']"));

        for (WebElement row:tableRows) {
            List<WebElement> cells = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div[@role='row']/div/div"));
            HashMap<String,String> rowData = new HashMap<>();
            rowData.put("UserName",cells.get(1).getText());
            rowData.put("User Role",cells.get(2).getText());
            rowData.put("Employee Name",cells.get(3).getText());
            rowData.put("Status",cells.get(4).getText());
            tableData.add(rowData);
        }
        logger.info("The data fetched are " + tableData);
        return this;
    }
    public UserManagementService validateFetchedUser(String colName, String value) {
        logger.info("Validating the fetched user.");
        String fetchedData = null;
        for (Map<String, String> row : tableData) {
            Assert.assertEquals(row.get(colName),value);
            if (row.get(colName).equals(value)) {
                fetchedData = row.get(colName);
            }
        }
        logger.info("Fetched data " + fetchedData + " is same as the value we have searched " + value+".");
        tableData.clear();
        return this;
    }
    /*public UserManagementService getUserSearchData(WebElement ele) {
        logger.info("Validating the fetched user.");
        checkAppearanceOfElement(ele,"No Record Found Note")
                .checkAppearanceOfElement()
        return this;
        }*/
    public UserManagementService clickOnAddUserBtn() {
        clickOnButton(addUserBtn,"Add user button").checkAppearanceOfElement(addUserHeader,"Add User header");
        return this;
    }
    /*public UserManagementService verifyAddUserForm() {
        checkAvailableLabels(driver.findElements(By.tagName("label")),addUserDivLabel)
                .verifyAvailableDropdownOptions();
        return this;
    }*/

    }