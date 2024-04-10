package scripts;

import dataprovider.Provider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2Test extends BaseTest {

    @BeforeMethod
    void beforeMethod() {
        driver.get("https://google.com");
    }

    @Test(dataProviderClass = Provider.class, dataProvider = "data")
    void createClaim(String data) {
        System.out.println("Testing with " + data);
    }
}
