package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.webdrivers.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public WebDriverManager webDriverManager;
    private static Logger logger = LogManager.getLogger(BaseTest.class.getName());;
    private static final String screenShotsFolder = "screenshots";

    @BeforeClass
    public WebDriver getDriver() {
        if (driver == null) {
            webDriverManager = new WebDriverManager();
            driver = webDriverManager.getDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public String getScreenshotPath(String result, WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+result+".png";
        FileHandler.copy(source,new File(destinationFile));
        return destinationFile;
    }

}
