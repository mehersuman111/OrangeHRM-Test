package pageObjects.basePage;

import com.beust.ah.A;
import framework.logging.LogManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
<<<<<<< HEAD
import org.openqa.selenium.*;
=======
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
>>>>>>> 34b17698cf4c8763e7eaf26d8f4fd95dc6157e74
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonPage extends PageInit {
    @FindBy(xpath = "//ul[@class='oxd-main-menu']//li//a")
    protected List<WebElement> mainMenus;
    @FindBy(xpath = "//div[@role='listbox']")
    protected WebElement optList;
    @FindBy(xpath = "//textarea[@title='Search']")
    public WebElement googleSB;
    @FindBy(xpath = "//ul[@role='listbox']/li//div[@role='option']")
    public List<WebElement> suggestedList;
    @FindBy(xpath = "//cite[@role='text']")
    public  List<WebElement> availableURLs;
    @FindBy(xpath = "(//button[substring(@class,1,8)='oxd-icon'])[1]")
    protected WebElement leftpanelBtn;
    @FindBy(xpath = "(//button[substring(@class,1,8)='oxd-icon'])[1]//i")
    protected WebElement leftPanelBtnArrowIcon;
    private Logger logger = LogManager.getLogger(CommonPage.class);;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Select cpSelectDD;
    List<String> optionsList = new ArrayList<>();

    protected String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    public CommonPage provideTextFieldValue(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }
    public CommonPage verifyTextElement(WebElement element, String value) {
        Assert.assertEquals(element.getText(),value);
        return this;
    }

    public CommonPage clickOnButton(WebElement btn, String BtnName) {
        btn.click();
        return this;
    }

    /*public CommonPage checkAppearanceOfElement(WebElement ele, String eleName) {
        Assert.assertEquals(ele.isDisplayed(), true, eleName + " has been displayed");
        return this;
    }*/
    public CommonPage checkAppearanceOfElement(WebElement ele, String eleName) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        Assert.assertEquals(ele.isDisplayed(), true, eleName + " has been displayed");
        return this;
    }

    public CommonPage checkAvailableElement(WebElement ele, String eleName) {
        Assert.assertEquals(ele.isDisplayed(), true);
        LogManagement.logMessage("INFO", eleName + " is available");
        return this;
    }
    public CommonPage checkAvailableLabels(List<WebElement> labels,List<Object> explabels) {
        ArrayList<String> labelsShown = new ArrayList<>();
        for (WebElement label:labels) {
            labelsShown.add(label.getText());
        }
        Assert.assertEquals(labelsShown,explabels);
        LogManagement.logMessage("INFO", "The available fields labels are " + labelsShown);
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
        checkAppearanceOfElement(optList, "Dropdown Options");
        List<WebElement> ddOptionsEle = optList.findElements(By.xpath("//div[@role='option']"));
<<<<<<< HEAD
        Assert.assertEquals(ddOptionsEle.size(), totalOpts, "Total options are available in the dropdown is " + ddOptionsEle.size());
=======
        Assert.assertEquals(ddOptionsEle.size(), totalOpts, "Total options are available in the dropdown is " + totalOpts);
>>>>>>> 34b17698cf4c8763e7eaf26d8f4fd95dc6157e74
        List<String> ddOptions = new ArrayList<>();
        for (WebElement ddOption : ddOptionsEle) {
            ddOptions.add(ddOption.getText());
        }
        logger.info("Comparing the options available in the dropdown " + ddOptions + " with the expected options " + options);
        Assert.assertEquals(ddOptions, options);
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
    public CommonPage getElementSource(WebElement btn,String attName) {
        try {
            System.out.println(driver.getPageSource());
            LogManagement.logMessage("INFO", btn.getDomAttribute(attName));
            System.out.println(btn.getAttribute(attName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    public CommonPage selectDropdownOption(WebElement ddEle, String ddName, String visibleText) {
        cpSelectDD = new Select(ddEle);
        cpSelectDD.selectByVisibleText(visibleText);
        LogManagement.logMessage("INFO","The value " + visibleText + " is selected in the" + ddName + " dropdown");
        return this;
    }
    public CommonPage selectDropdownOption(WebElement ddEle, String ddName, String value, String visibleText) {
        cpSelectDD = new Select(ddEle);
        cpSelectDD.selectByValue(value);
        LogManagement.logMessage("INFO","The value " + value + " i.e., " + visibleText +"is selected in the" + ddName + " dropdown");
        return this;
    }
    public CommonPage selectDropdownOption(WebElement ddEle, String ddName, int index, String visibleText) {
        cpSelectDD = new Select(ddEle);
        cpSelectDD.selectByIndex(index);
        LogManagement.logMessage("INFO","The value at index " + index + " i.e., " + visibleText +"is selected in the" + ddName + " dropdown");
        return this;
    }
    public CommonPage verifyAvailableOptionsInDropdown(WebElement ddEle, String ddName, int index, String visibleText) {
        cpSelectDD = new Select(ddEle);
        List<WebElement> options = cpSelectDD.getOptions();
        /*for (int i = 0; i < options.size(); i ++) {
            String optVal = options.get(i).getText();
            optionsList.add(optVal);
        }*/
        for (WebElement eleOpt:options) {
            optionsList.add(eleOpt.getText());
        }
        Assert.assertEquals(optionsList,new ArrayList<>());
        //LogManagement.logMessage("INFO","The value at index " + index + " i.e., " + visibleText +"is selected in the" + ddName + " dropdown");
        return this;
    }
    public CommonPage selectFromAutoSuggestDD(List<WebElement> options, String att1, String att2, String val1, String val2) {
        for (WebElement option:options) {
            if (option.getAttribute(att1).equals(val1) && option.getAttribute(att2).equals(val2)) {
                option.click();
                LogManagement.logMessage("INFO","Clicked on ");
            }
            LogManagement.logMessage("INFO","The suggestion shown is " + option.getAttribute(att1) + " - " + option.getAttribute(att2));
        }
        return this;
    }
    public CommonPage selectFromAutoSuggestDD(List<WebElement> options, String att1, String val1) {
        for (WebElement option:options) {
            if (option.getAttribute(att1).equals(val1)) {
                option.click();
                LogManagement.logMessage("INFO","Clicked on ");
            }
            LogManagement.logMessage("INFO","The suggestion shown is " + option.getAttribute(att1));
        }
        return this;
    }
    public CommonPage selectFromAvailableURLs(List<WebElement> urls, String urlLink) {
        for (WebElement url:urls) {
            if (url.getText().equals(urlLink)) {
                url.click();
                LogManagement.logMessage("INFO","Clicked on ");
            }
            LogManagement.logMessage("INFO","The url available is " + url.getAttribute(urlLink));
        }
        return this;
    }
    public CommonPage validateCurrentURL(String url) {
        driver.getCurrentUrl().equals(url);
        return this;
    }
    public CommonPage letPanelArrowButtonClick(String arrowSideB,String arrowSideA) {
        if (leftPanelBtnArrowIcon.getAttribute("class").contains(arrowSideB)) {
            wait.until(ExpectedConditions.elementToBeClickable(leftpanelBtn)).click();
        }
        LogManagement.logMessage("INFO", "Click on the left panel arrow button");
        Assert.assertTrue(leftPanelBtnArrowIcon.getAttribute("class").contains(arrowSideA));
        return this;
    }
<<<<<<< HEAD
    // Utility to get the Shadow DOM element
    public WebElement getShadowDOM(WebElement ele, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDOM = (WebElement) js.executeAsyncScript("return arguments[0].shadowRoot", ele);
        return  shadowDOM;
    }
=======
>>>>>>> 34b17698cf4c8763e7eaf26d8f4fd95dc6157e74
}