package base_tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import webui.applications.PageApplications;
import webui.constants.URL;
import webui.utils.ExtentListenerUtil;
import webui.utils.ExtentReportUtil;
import webui.utils.WebDriverUtil;

@Listeners(ExtentListenerUtil.class)
public abstract class WebUIBaseTest {

    protected PageApplications pageApplications;
    protected SoftAssert softAssert;
    ExtentReportUtil extentReportUtil = new ExtentReportUtil();


    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser){
        System.out.println("BeforeTest: Setting up WebDriverUtil manager for browser: " + browser);
        WebDriverUtil.setUpDriverManager(browser);
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(ITestResult iTestResult, @Optional("chrome") String browser) {
        System.out.println("BeforeMethod: Setting up WebDriverUtil for browser: " + browser);
        WebDriverUtil.setDriver(browser);
        System.out.println("BeforeMethod: Navigating to Parabank");
        WebDriverUtil.getURL(URL.parabank);
        pageApplications = new PageApplications(WebDriverUtil.getDriver());
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod: Quitting WebDriverUtil");
        WebDriverUtil.quitDriver();
    }

}

