package pageObjects.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageInit {
    protected WebDriver driver;
    public PageInit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}