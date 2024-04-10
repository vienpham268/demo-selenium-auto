package dataprovider;

import org.testng.annotations.DataProvider;

public class Provider {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{{"data1"}, {"data2"}, {"data3"}};
    }
}
