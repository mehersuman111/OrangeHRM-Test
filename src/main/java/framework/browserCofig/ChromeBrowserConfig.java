package framework.browserCofig;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeBrowserConfig {
    ChromeOptions options = new ChromeOptions();
    public ChromeOptions getChromeOptions() {
        options.addArguments("--headless=new");             // To run the test in headless mode
        options.setAcceptInsecureCerts(true);               // To accept insecure certificates
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // To exclude automation switch
        options.addArguments("--incgnito");                 // To run the test in incognito mode
        File file1 = new File("C:\\Suman\\Automation\\MyWorkSpaces\\OrangeHRM-Test\\src\\test\\resources\\crxFiles\\GoogleTranslate.crx");
        options.addExtensions(file1);                       // To add the extension
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        return options;
    }
}