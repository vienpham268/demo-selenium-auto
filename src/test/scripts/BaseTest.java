package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "environment"})
    void beforeClass(@Optional("chrome") String browser, @Optional("SIT") String envi) {
        System.out.println("Before class");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @AfterClass
    void killDriver() {
        System.out.println("After class");
        if (this.driver != null)
            this.driver.quit();
    }



}
