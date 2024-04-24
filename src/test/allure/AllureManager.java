package allure;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scripts.BaseTest;

public class AllureManager {
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] captureImage() {
        return ((TakesScreenshot) BaseTest.driverThread.get()).getScreenshotAs(OutputType.BYTES);
    }
}
