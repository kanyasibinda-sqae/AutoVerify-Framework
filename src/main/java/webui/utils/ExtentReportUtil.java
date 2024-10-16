package webui.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestResult;

public class ExtentReportUtil {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public ExtentTest getTest(){
        return test.get();
    }

    public void setUpExtentReport(String browser) {
        String reportPath = System.getProperty("user.dir") + "/extent-reports/"+browser+"-report.html";
        System.out.println(reportPath);
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Extent Reports");
        sparkReporter.config().setReportName("My Extent Report");

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Tester", "Kanya");
        reports.setSystemInfo("environment", "staging");
    }

    public void createTest(ITestResult iTestResult) {
        ExtentTest extentTest = reports.createTest(iTestResult.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void getTestResults(ITestResult iTestResult) throws InterruptedException{
        String resultName;
        Markup markup;
        
        if (iTestResult.getStatus() == ITestResult.SUCCESS){
            resultName = "TC: " + iTestResult.getName() + " - PASSED";
            markup = MarkupHelper.createLabel(resultName, ExtentColor.GREEN);
            getTest().log(Status.PASS, markup);

        } else if (iTestResult.getStatus() == ITestResult.FAILURE) {
            resultName = "TC: " + iTestResult.getName() + " - FAILED";
            markup = MarkupHelper.createLabel(resultName, ExtentColor.RED);
            getTest().log(Status.FAIL, markup);
            
            
            String screenshotName = iTestResult.getMethod().getMethodName();
            String screenshotPath = ScreenshotUtil.takeScreenshot(WebDriverUtil.getDriver(), screenshotName);
            getTest().log(Status.INFO, "Screenshot attached").addScreenCaptureFromPath(screenshotPath);
            getTest().log(Status.INFO, iTestResult.getThrowable());
            

        } else if (iTestResult.getStatus() == ITestResult.SKIP) {
            resultName = "TC: " + iTestResult.getName() + " - SKIPPED";
            markup = MarkupHelper.createLabel(resultName, ExtentColor.ORANGE);
            getTest().log(Status.SKIP, markup);
            getTest().log(Status.SKIP, iTestResult.getThrowable());
        }
    }

    public void flushExtentReports(){
        if (reports != null){
            try {
                reports.flush();
            }catch (Exception e){
                e.getMessage();
            }
        }

    }
}
