package framework.visualEvidence;

import framework.globalConstants.PathConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import framework.browserCofig.TestInit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ScreenshotManager {
    static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    public static String takeScreenShot(String testName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) TestInit.driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = new String(System.getProperty("user.dir")+ PathConfig.testOutput +"\\screenShots\\"+testName+timeStamp+".png");
        File targetFile = new File(targetFilePath);
        //sourceFile.renameTo(targetFile);
        FileUtils.copyFile(sourceFile,targetFile);
        return targetFilePath;
    }
}