package webui.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public interface Listener extends ITestListener {
    
    void onStart(ITestContext context);

    void onTestStart(ITestResult result);

    void onTestSuccess(ITestResult result);

    void onTestFailure(ITestResult result);

    void onTestSkipped(ITestResult result);

    void onFinish(ITestContext context);
 
}
