package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.YamlUtils;

import java.util.Map;

public class BaseTest {
    public static ThreadLocal<WebDriver> driverThread = ThreadLocal.withInitial(() -> null);
    public static Map environment;

    @BeforeClass
    @Parameters({"browser", "environment"})
    public void beforeClass(@Optional("chrome") String browser, @Optional("dev") String envi) {
        environment = YamlUtils.getConfig("src/resources/env-" + envi + ".yaml");
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
        driverThread.get().get(environment.get("url").toString());
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
