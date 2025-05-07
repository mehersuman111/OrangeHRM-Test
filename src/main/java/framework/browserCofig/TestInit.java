package framework.browserCofig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import services.admin.userMgmt.UserManagementService;
import services.dashboard.DashboardService;
import services.logIn.LogInService;
import services.starterHelp.StarterHelpService;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestInit extends ChromeBrowserConfig {

    protected static WebDriver driver;
    public static Logger logger;
    protected LogInService ls;
    protected static DashboardService dashboardService;
    protected static StarterHelpService starterHelpService;
    public static Properties properties;
    public static UserManagementService userManagementService;

    //Implementing the Soft Assertion (Verify method)
    SoftAssert softAssert = new SoftAssert();

    //@BeforeClass
    //@BeforeSuite
    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String br, ITestContext context) throws IOException {
        System.out.println("The setup method is getting started ...");
        logger = LogManager.getLogger(this.getClass());
        //PropertyConfigurator.configure(".\\src\\main\\resources\\log4j2.properties");

        String xmlFileName = context.getSuite().getXmlSuite().getFileName();
        String browserName = context.getSuite().getXmlSuite().getParameter("browser");
        System.out.println("Provided the browser param as '"+ browserName +"' in currently running the XML file " + xmlFileName);
        // Initialize the WebDriver based on the browser parameter
        switch (br.toLowerCase()) {
         case "chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
                driver = new ChromeDriver(options);
                break;
            case "edge":
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
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Read the properties file
        FileReader fileReader = new FileReader(".\\src\\main\\resources\\property\\config.properties");
        properties = new Properties();
        properties.load(fileReader);

        ls = new LogInService(driver);
        dashboardService = new DashboardService(driver);
        starterHelpService = new StarterHelpService(driver);
        userManagementService = new UserManagementService(driver);

        //To check the connectivity status of the URL
        URL url = new URL(properties.getProperty("orangeHRM.URL"));
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();

        if (httpURLConnection.getResponseCode()>=200 && httpURLConnection.getResponseCode() < 300) {
            System.out.println("The URL provided '" + url + "' is connecting properly.");
            driver.get(url.toString());
        } else {
            System.out.println("URL is not connecting. Please check the URL.");
            if (httpURLConnection.getResponseCode() >= 400 && httpURLConnection.getResponseCode() < 500) {
                System.out.println("URL is not connecting properly and there is some server side issue happening");
            } else if (httpURLConnection.getResponseCode() >= 500) {
                System.out.println("URL is not connecting properly and there is some client side issue happening");
            }
        }
    }

    @AfterTest
    public void tearDown() {
        softAssert.assertAll();
        if (driver!=null) {
            driver.quit();
        }
        System.out.println("Test Suite execution has been completed.");
    }
}