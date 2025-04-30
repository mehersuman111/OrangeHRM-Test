package pageObjects.starterHelp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.basePage.CommonPage;

import java.util.List;

public class StarterHelpTab extends CommonPage {

    @FindBy(xpath = "//button[@title='Help']")
    protected WebElement starterHelpButton;
    @FindBy(id = "main-content")
    protected WebElement mainContent;
    @FindBy(id = "query")
    protected WebElement searchBox;
    @FindBy(css = "li.blocks-item")
    protected List<WebElement> helpTopics;
    @FindBy(linkText = "OrangeHRM")
    protected WebElement orangeHRMHelpLink;
    @FindBy(linkText = "Sign in")
    protected WebElement helpSignInLink;

    public StarterHelpTab(WebDriver driver) {
        super(driver);
    }
}
