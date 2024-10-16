package webui.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import webui.testng.Listener;

public class ExtentListenerUtil implements Listener {

    private ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    @Override
    public void onStart(ITestContext context) {
        String browser = context.getCurrentXmlTest().getParameter("browser");
        extentReportUtil.setUpExtentReport(browser);
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentReportUtil.createTest(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            extentReportUtil.getTestResults(iTestResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            extentReportUtil.getTestResults(iTestResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        try {
            extentReportUtil.getTestResults(iTestResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReportUtil.flushExtentReports();
    }
}




