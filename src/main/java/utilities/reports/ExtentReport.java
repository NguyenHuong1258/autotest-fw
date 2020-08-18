package utilities.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.IReporter;

public class ExtentReport implements IReporter {

    public static ExtentReports extent;
    static String reportFolder = "TestReport";

    public static ExtentReports extentGenerator(){
        String path = reportFolder + "/" + "report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Report");
        reporter.config().setDocumentTitle("Test Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        reporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Testing Report", "NMA");
        return extent;
    }
}
