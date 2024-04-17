package listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import scripts.BaseTest;

public class Listener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        ((TakesScreenshot) driverThread.get()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }
}
