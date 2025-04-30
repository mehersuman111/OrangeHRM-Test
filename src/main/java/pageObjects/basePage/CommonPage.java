package pageObjects.basePage;

import com.beust.ah.A;
import framework.logging.LogManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonPage extends PageInit {
    @FindBy(xpath = "//ul[@class='oxd-main-menu']//li//a")
    protected List<WebElement> mainMenus;
    @FindBy(css = "ul.oxd-dropdown-menu")
    protected WebElement ulElement;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    protected String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    public CommonPage provideTextFieldValue(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public CommonPage clickOnButton(WebElement btn, String BtnName) {
        btn.click();
        return this;
    }

    public CommonPage checkAppearanceOfElement(WebElement ele, String eleName) {
        Assert.assertEquals(ele.isDisplayed(), true, eleName + " has been displayed");
        return this;
    }

    public CommonPage checkAvailableElement(WebElement ele, String eleName) {
        Assert.assertEquals(ele.isDisplayed(), true);
        LogManagement.logMessage("INFO", eleName + " is available");
        return this;
    }
    public CommonPage checkAvailableElement(List<WebElement> elements, String eleName, String shouldAvailable) {
        for (WebElement element : elements) {
            Assert.assertEquals(element.isDisplayed(), true, eleName + " is" + shouldAvailable + " available");
        }
        return this;
    }
    public CommonPage checkAvailableElement(WebElement ele, String eleName, String shouldAvailable) {
        Assert.assertEquals(ele.isDisplayed(), true, eleName + " is" + shouldAvailable + " available");
        return this;
    }
    public CommonPage checkAvailableElement(WebElement ele, String eleName,int count) {
        int checkCount = 0;
        while (checkCount < count) {
            try {
                Assert.assertEquals(ele.isDisplayed(), true);
                LogManagement.logMessage("INFO", eleName + " is available");
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public CommonPage switchToDesireTab(String tabName) {
        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("Switched to " + tabName + " tab");
        return this;
    }
    public CommonPage selectAMenu(String menuName, String attributeValue) throws InterruptedException {
        for (WebElement menu : mainMenus) {
            if (menu.getText().equalsIgnoreCase(menuName) && !menu.getAttribute("class").contains(attributeValue)) {
                menu.click();
                Thread.sleep(2000);
                //Assert.assertTrue(menu.getAttribute("class").contains(attributeValue), menuName + " has been selected successfully");
                break;
            }
        }
        return this;
    }
    public CommonPage verifyAvailableDropdownOptions(WebElement ddEle, List<String> options, int totalOpts) {
        ddEle.click();
        checkAppearanceOfElement(ulElement, "Dropdown Options");
        List<WebElement> ddOptionsEle = ulElement.findElements(By.tagName("li"));
        Assert.assertEquals(ddOptionsEle.size(), totalOpts, "Total options are available in the dropdown is " + totalOpts);
        List<String> ddOptions = new ArrayList<>();
        for (WebElement ddOption : ddOptionsEle) {
            ddOptions.add(ddOption.getText());
        }
        Assert.assertEquals(ddOptions, options, "Comparing the options available in the dropdown " + ddOptions + " with the expected options " + options);

        return this;
    }
    public  CommonPage verifyTextField(WebElement textFelement, String textFname, boolean value) {
        Assert.assertEquals(textFelement.isEnabled(), value, textFname + " is displayed");
        LogManagement.logMessage("INFO", textFname + " is displayed");
        LogManagement.logMessage("INFO", "Is the text field enabled? " + textFelement.isEnabled());
        return this;
    }
    public  CommonPage provideTextFieldValue(WebElement element, String value, String elementName) {
        element.sendKeys(value);
        LogManagement.logMessage("INFO", value + " has been entered in the " + elementName + " field");
        return this;
    }
}