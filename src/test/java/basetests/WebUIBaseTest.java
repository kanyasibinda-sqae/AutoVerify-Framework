package basetests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import webui.utils.ExtentListenerUtil;
import webui.utils.WebDriverUtil;

@Listeners(ExtentListenerUtil.class)
public abstract class WebUIBaseTest {

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
        System.out.println("BeforeMethod: Navigating to ");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod: Quitting WebDriverUtil");
        WebDriverUtil.quitDriver();
    }

}

