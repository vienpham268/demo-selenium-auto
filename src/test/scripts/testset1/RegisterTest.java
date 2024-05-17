package scripts.testset1;

import dataprovider.Provider;
import dto.RegisterPaidTraining;
import org.testng.annotations.Test;
import scripts.BaseTest;

public class RegisterTest extends BaseTest {
    @Test(dataProviderClass = Provider.class, dataProvider = "getData")
    public void registerPaidTraining(RegisterPaidTraining data) {
        System.out.println(data.getFirstName());
    }
}
