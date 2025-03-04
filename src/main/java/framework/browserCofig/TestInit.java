package framework.browserCofig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import services.dashboard.DashboardService;
import services.logIn.LogInService;

import java.util.concurrent.TimeUnit;

public class TestInit {

    protected static WebDriver driver;
    protected static LogInService ls;
    protected static DashboardService dashboardService;

    private static String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @BeforeSuite
    public static void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        ls = new LogInService(driver);
        dashboardService = new DashboardService(driver);
    }
}