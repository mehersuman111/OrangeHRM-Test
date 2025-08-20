package framework.browserCofig;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserOptionConfig {
    ChromeOptions chromeOptions = new ChromeOptions();
    EdgeOptions edgeOptions = new EdgeOptions();
    public BrowserOptionConfig getChromeOptions() {
        //chromeOptions.addArguments("--headless=new");                             // To run the test in headless mode
        chromeOptions.setAcceptInsecureCerts(true);                               // To accept insecure certificates
        Map<String, Object> prefs = new HashMap<>();
        //prefs.put("excludeSwitches", new String[]{"enable-automation"});    // To exclude automation switch
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        chromeOptions.setExperimentalOption("prefs",prefs);
        //options.addArguments("--incgnito");                                 // To run the test in incognito mode
        //chromeOptions.addArguments("--guest");
        //File file1 = new File("C:\\Suman\\Automation\\MyWorkSpaces\\OrangeHRM-Test\\src\\test\\resources\\crxFiles\\GoogleTranslate.crx");
        //options.addExtensions(file1);                                       // To add the extension
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        // To disable to user profile in chrome
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--no-default-browser-check");
        chromeOptions.addArguments("--disable-features=ChromeWhatsNewUI");
        chromeOptions.addArguments("--disable-popup-blocking");
        return this;
    }
    public BrowserOptionConfig getEdgeOptions() {
        //edgeOptions.addArguments("user-agent=Edg/124.0.2478.51");
        edgeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36 Edg/124.0.2478.51");
        //edgeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        edgeOptions.setExperimentalOption("useAutomationExtension", false);
        return this;
    }
}