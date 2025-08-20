package framework.listenerActions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import framework.visualEvidence.ScreenshotManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ExtentTest test;

    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(".\\src\\test\\outputs\\htmlReports\\" + LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))+".html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("System Name",System.getProperty("user.name"));
        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("Test Engineer Name", "Suman Kumar Meher");   // Currently HardCoded
        reports.setSystemInfo("OS",System.getProperty("os.version"));
        reports.setSystemInfo("Browser Type",context.getSuite().getXmlSuite().getParameter("browser"));
    }
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        String testDescription = result.getMethod().getDescription();
        test = reports.createTest(testName,"<b><font color='#D8CBB8'>"+testDescription+"</font></b>");
    }
    public void onTestSuccess(ITestResult result) {
        //test = reports.createTest(result.getName());
        test.log(Status.PASS,"Testcase passed is " + result.getName());
    }
    public void onTestFailure(ITestResult result) {
        //test = reports.createTest(result.getName());
        test.log(Status.FAIL,"Testcase failed is " + result.getName());
        try {
            String imagePath = ScreenshotManager.takeScreenShot(result.getName());
            test.addScreenCaptureFromPath(imagePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}