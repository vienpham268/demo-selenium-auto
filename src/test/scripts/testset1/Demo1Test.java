package scripts.testset1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Demo1Test {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "environment"})
    void beforeClass(@Optional("chrome") String browser, @Optional("SIT") String envi) {
        System.out.println("Before class");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Will be run for each test case");
    }

    @Test
    void newTest1() {
        this.driver.get("https://google.com");
        System.out.println("Finish test case 1");
    }

    @Test
    void newTest2() {
        this.driver.get("https://google.com");
        System.out.println("Finish test case 2");
        this.driver = null;
    }

    @AfterClass
    void killDriver() {
        System.out.println("Stop test case");
        if (driver != null)
            this.driver.quit();
    }


}
