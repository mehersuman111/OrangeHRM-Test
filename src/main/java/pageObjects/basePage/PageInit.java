package pageObjects.basePage;

import framework.browserCofig.TestInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageInit  {
    public WebDriver driver;
    public PageInit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}