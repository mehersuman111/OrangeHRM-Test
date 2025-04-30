package framework.browserCofig;

import framework.urlConnector.URLConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import services.admin.userMgmt.UserManagementService;
import services.dashboard.DashboardService;
import services.logIn.LogInService;
import services.starterHelp.StarterHelpService;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestInit extends ChromeBrowserConfig {

    protected static WebDriver driver;
    public static Logger logger;
    protected static LogInService ls;
    protected static DashboardService dashboardService;
    protected static StarterHelpService starterHelpService;
    public static Properties properties;
    public static UserManagementService userManagementService;

    //@BeforeClass
    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(String br) throws IOException {
        logger = LogManager.getLogger(this.getClass());
        //PropertyConfigurator.configure(".\\src\\main\\resources\\log4j2.properties");

        // Initialize the WebDriver based on the browser parameter
        //switch (br.toLowerCase()) {
          //  case "chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
            //    break;
            /*case "edge":
                System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\driver\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser not supported");
                return;
        }*/

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Read the properties file
        FileReader fileReader = new FileReader(".\\src\\main\\resources\\property\\config.properties");
        properties = new Properties();
        properties.load(fileReader);

        //To check the connectivity status of the URL
        if (URLConnector.checkURLConnectivity(properties.getProperty("orangeHRM.URL"))) {
            System.out.println("URL is connecting properly.");
            driver.get(properties.getProperty("orangeHRM.URL"));
        } else {
            System.out.println("URL is not connecting. Please check the URL.");
        };

        ls = new LogInService(driver);
        dashboardService = new DashboardService(driver);
        starterHelpService = new StarterHelpService(driver);
        userManagementService = new UserManagementService(driver);
    }
}