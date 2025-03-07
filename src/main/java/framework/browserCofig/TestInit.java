package framework.browserCofig;

import framework.urlConnector.URLConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import services.dashboard.DashboardService;
import services.logIn.LogInService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestInit {

    protected static WebDriver driver;
    protected static LogInService ls;
    protected static DashboardService dashboardService;
    public static Properties properties;
    @BeforeSuite
    public static void setUp() throws IOException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
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
    }
}