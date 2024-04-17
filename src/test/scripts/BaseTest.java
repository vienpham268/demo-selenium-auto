package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static ThreadLocal<WebDriver> driverThread = ThreadLocal.withInitial(() -> null);

    @BeforeClass
    @Parameters({"browser", "environment"})
    public void beforeClass(@Optional("chrome") String browser, @Optional("sit") String envi) {
        switch (browser) {
            case "chrome":
                driverThread.set(new ChromeDriver());
                break;
            case "firefox":
                driverThread.set(new FirefoxDriver());
                break;
            default:
                System.out.println("Unknown browser");
        }
        driverThread.get().manage().window().maximize();
        driverThread.get().get("https://gh-users-search.netlify.app/");
    }

    @AfterClass
    public void killDriver() {
        System.out.println("After class of test, killing driver...");
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }

}
