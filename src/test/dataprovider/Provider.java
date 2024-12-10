package dataprovider;

import dto.RegisterPaidTraining;
import org.testng.annotations.DataProvider;

import static utils.ArrayUtils.generate2DimArray;

public class Provider {
    @DataProvider
    public static Object[][] netlifySearchKeywords() {
        return new Object[][]{{"john"}, {"kathy"}, {"peter"}};
    }

    @DataProvider
    public static Object[][] getData() {
        return generate2DimArray(RegisterPaidTraining.class, "src/resources/data/register.json");
    }

}
