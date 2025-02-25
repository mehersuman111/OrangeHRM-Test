package pageObjects.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
