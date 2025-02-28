package webTest.LoginMgmt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.logIn.LogInService;
import pageObjects.logIn.LogInPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    static WebDriver driver;
    public static String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static LogInService ls;
    @BeforeClass
    public static void initializeDriver() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\driver\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        ls = new LogInService(driver);
    }

    @DataProvider(name = "loginCredentials")
    Object[][] loginCredentialData() {
        Object data[][] = {
                {"admin", "admin@123"},
                {"agent", "agent@123"},
                {"user", "user@123"},
                {"manager", "manager@123"},
                {"Admin","admin123"}
        };
        return data;
    }

    @Test(dataProvider = "loginCredentials")
    public void UI_Web_01_Test_Login(String username, String password) {

        ls.provideLoginCredential(username, password)
                .clickOnLoginBtn();
        if (!(username.equals("Admin") && password.equals("admin123"))) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
        } else {
            Assert.assertTrue(driver.findElement(By.xpath("//h6")).isDisplayed());
        }
    }

}
