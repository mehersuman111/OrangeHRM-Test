package webTest.LoginMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.logIn.LogInService;

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
    @Test
    public void UI_Web_01_Test_Login() {

        ls.provideLoginCredential()
                .clickOnLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl().equals("Test"), true);
    }

}
