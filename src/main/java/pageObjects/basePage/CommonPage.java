package pageObjects.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CommonPage extends PageInit {
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
    public CommonPage checkAvailableElement(WebElement ele, String eleName) {
        Assert.assertEquals(ele.isDisplayed(), true, eleName + " is available");
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


}
