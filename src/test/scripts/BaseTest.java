package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "environment"})
    public void beforeClass(@Optional("chrome") String browser, @Optional("sit") String envi) {
        switch (browser) {
            case "chrome":
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Unknown browser");
        }
        System.out.println("Starting browser " + browser + " in " + envi.toUpperCase() + " environment...");
        this.driver.manage().window().maximize();
        this.driver.get("https://gh-users-search.netlify.app/");
    }

    @AfterClass
    public void killDriver() {
        System.out.println("After class of test, killing driver...");
        if (this.driver != null)
            this.driver.quit();
    }

}
